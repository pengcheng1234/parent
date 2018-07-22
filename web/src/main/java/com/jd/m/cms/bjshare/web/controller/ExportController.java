package com.jd.m.cms.bjshare.web.controller;

import com.github.pagehelper.PageInfo;
import com.jd.m.cms.bjshare.client.activity.ShareActivityCommonService;
import com.jd.m.cms.bjshare.common.exportexcel.BatchExportToExcelUtil;
import com.jd.m.cms.bjshare.domain.po.ActivityDataStatistical;
import com.jd.m.cms.bjshare.domain.po.ActivityTranDataStatistical;
import com.jd.m.cms.bjshare.domain.po.ShareActivity;
import com.jd.m.cms.bjshare.domain.vo.CouponDataVo;
import com.jd.m.cms.bjshare.domain.vo.IdsAndAuditStatus;
import com.jd.m.cms.bjshare.domain.vo.OrderDataVo;
import com.jd.m.cms.bjshare.domain.vo.export.CouponTranDataVo;
import com.jd.m.commodity.produce.service.ProduceService;
import com.jd.m.njf.server.client.util.JsonUtil;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.*;

/**
 * @Author: zhaoxiaoguang
 * @Description:
 * @Date: created in 2018/5/14
 * @Modidied By:
 **/
@Controller
@RequestMapping("/export")
public class ExportController {




    @Resource
    private ShareActivityCommonService shareActivityCommonService;

    @Resource
    private ProduceService myProduceService;



    /**
     * 获取商品id的数据列表 by lipengcheng 2018.7.13
     * @param activityId 活动id
     * @param userType 用户类型（1：pop  2：运营）
     */
        @RequestMapping(value = "/excelThingIdsList.do", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public void excelThingIdsList(HttpServletResponse response, Long activityId, Integer userType){
        if(activityId == null||userType==null){
            return;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("activityId", activityId);
        List<IdsAndAuditStatus> IdsAndAuditStatusList=new ArrayList<IdsAndAuditStatus>();
        String[] headers=null;
        String[] columns=null;
        switch(userType){//0：pop  1：运营
            case 0:
                ShareActivity shareActivity =shareActivityCommonService.getThingIdsListByPop(map);
                if(shareActivity!=null){
                    String bizIds=shareActivity.getBizIds();
                    String[] ids=bizIds.split(",");//从对象中获取的id集合
                    System.out.println("遍历ids数组============"+Arrays.toString(ids));
                    if(shareActivity.getMatchType()==(byte)2){//1sku，2spu，3店铺id，4通天塔id',pop只判断2和3
                        headers=new String[]{"序号", "spu","sku"};
                        columns=new String[]{"serialId","spuId","id"};
                        int size=ids.length;//对象id集合中的id个数
                        int num=size/99;//循环的次数，调用jsf接口，传递参数的集合个数每次不能超过99
                        int yu=size%99;//余数是不是0，下面判断循环的次数
                        if(yu!=0){//有余数循环次数+1
                            num=num+1;
                        }
                        Map<Long, String> mapskuAll=new HashMap<Long, String>();
                        if(num>1){//多次调用jsf
                            for (int i=0;i<num;i++){//循环调用jsf
                                Set setspuids=new HashSet<Long>();
                                if(i!=num-1){
                                    for(int j=i*99;j<(i+1)*99;j++){
                                        setspuids.add(Long.valueOf(ids[j]));
                                    }
                                }else{//最后一次
                                    for(int j=(num-1)*99;j<size;j++){
                                        setspuids.add(Long.valueOf(ids[j]));
                                    }
                                }for(Object value: setspuids){
                                    System.out.print((long)value);
                                }
                                Map<Long, String> mapsku=myProduceService.spuToSkus(setspuids);//通过spu转化为sku
                                mapskuAll.putAll(mapsku);
                            }
                        }else{//只调用一次jsf
                            Set setspuids = new HashSet<Long>();
                            for (String id : ids) {
                                setspuids.add(Long.valueOf(id));
                            }
                            Map<Long, String> mapsku=myProduceService.spuToSkus(setspuids);//通过spu转化为sku
                            mapskuAll.putAll(mapsku);
                        }
                        for(String id:ids){//id=spu,遍历jsf返回的sku结果，添加到list中
                            String skuId=mapskuAll.get(Long.valueOf(id));
                            if(skuId.contains(",")){//spu对应多个sku
                                String skuid[]=skuId.split(",");
                                for(String id1:skuid){
                                    IdsAndAuditStatus idsAndAuditStatus=new IdsAndAuditStatus();
                                    idsAndAuditStatus.setId(id1);
                                    idsAndAuditStatus.setSpuId(id);
                                    IdsAndAuditStatusList.add(idsAndAuditStatus);
                                }
                            }else{
                                IdsAndAuditStatus idsAndAuditStatus=new IdsAndAuditStatus();
                                idsAndAuditStatus.setId(skuId);
                                idsAndAuditStatus.setSpuId(id);
                                IdsAndAuditStatusList.add(idsAndAuditStatus);
                            }
                        }
                    }
                    if(shareActivity.getMatchType()==(byte)3){//店铺直接转化为id,1sku，2spu，3店铺id，4通天塔id',pop只判断2和3
                        headers=new String[]{"序号", "sku"};
                        columns=new String[]{"serialId","id"};
                        for(String id:ids){
                            IdsAndAuditStatus idsAndAuditStatus=new IdsAndAuditStatus();
                            idsAndAuditStatus.setId(id);
                            IdsAndAuditStatusList.add(idsAndAuditStatus);
                        }
                    }
                }
                break;
            case 1:
                headers=new String[]{ "序号", "sku","审核失败原因"};
                columns=new String[]{"serialId","id","auditStatus"};
                IdsAndAuditStatusList=shareActivityCommonService.getThingIdsListByOperation(map);//
                break;
            default:
                break;
        }
        String title = "活动"+activityId+"对应的商品ID";
        Workbook workbook = BatchExportToExcelUtil.createWorkBook(title,headers);
        try {
            workbook = BatchExportToExcelUtil.exportExcel(workbook, columns, IdsAndAuditStatusList,null);
        } catch (Exception e) {
        }
        export(workbook,title,response);


    }

    /**
     * I/o输出
     */
    private void export(Workbook workbook,String title,HttpServletResponse response) {
        response.setContentType("application/vnd.ms-excel");
        try {
            response.setHeader("Content-Disposition", "attachment;filename="
                    + new String((title + ".xlsx").getBytes(), "iso-8859-1"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            ServletOutputStream out =response.getOutputStream();
            workbook.write(out);
            out.flush();
            out.close();
        } catch (IOException e) {
        }
    }

}
