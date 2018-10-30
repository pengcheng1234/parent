package com.jd.m.cms.bjshare.web.controller;

import com.github.pagehelper.PageInfo;
import com.jd.m.cms.bjshare.client.activity.ShareActivityCommonService;
import com.jd.m.cms.bjshare.client.databoard.DataStatisticalJsfService;
import com.jd.m.cms.bjshare.client.databoard.ExcelJsfService;
import com.jd.m.cms.bjshare.common.exportexcel.BatchExportToExcelUtil;
import com.jd.m.cms.bjshare.common.log.TraceLog;
import com.jd.m.cms.bjshare.common.log.TraceLogFactory;
import com.jd.m.cms.bjshare.common.result.ResultCode;
import com.jd.m.cms.bjshare.common.result.ResultData;
import com.jd.m.cms.bjshare.common.utils.DateUtil;
import com.jd.m.cms.bjshare.dao.ActivityBizsMapper;
import com.jd.m.cms.bjshare.domain.po.*;
import com.jd.m.cms.bjshare.domain.vo.*;
import com.jd.m.cms.bjshare.domain.vo.export.CouponTranDataVo;
import com.jd.m.cms.bjshare.domain.vo.export.excelShareActivity;
import com.jd.m.cms.bjshare.web.service.LoginService;
import com.jd.m.commodity.produce.service.ProduceService;
import com.jd.m.njf.server.client.util.JsonUtil;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
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

    private static final TraceLog log = TraceLogFactory.getTraceLog(ExportController.class);

    @Resource
    private ExcelJsfService excelJsfService;
    @Resource
    private ShareActivityCommonService shareActivityCommonService;

    @Autowired
    private LoginService loginService;

    @Resource
    private ProduceService myProduceService;

  /*  @Autowired
    private ActivityBizsMapper activityBizsMapper;


    @RequestMapping(value = "/insertActivityBizs.do", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public void insertActivityBiz(HttpServletResponse response) {
        for (int i = 0; i < 6666; i++) {
            ActivityBizs dto = new ActivityBizs();
            dto.setActivityId(1);
            dto.setBizId(i+"");
            dto.setBizType((byte) 1);
            dto.setValidateResult((byte) 0);
            dto.setCreateTime(new Date());
            dto.setStatus((byte) 0);
            activityBizsMapper.insert(dto);

        }
    }*/

    /**
     * 获取商品id的数据列表 by lipengcheng 2018.7.13
     *
     * @param activityId 活动id
     * @param userType   用户类型（1：pop  2：运营）
     */
    @RequestMapping(value = "/excelThingIdsList.do", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public void excelThingIdsList(HttpServletResponse response, Long activityId, Integer userType) {
        if (activityId == null || userType == null) {
            return;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("activityId", activityId);
        List<IdsAndAuditStatus> IdsAndAuditStatusList = new ArrayList<IdsAndAuditStatus>();
        String[] headers = null;
        String[] columns = null;
        switch (userType) {//0：pop  1：运营
            case 0:
                ShareActivity shareActivity = shareActivityCommonService.getThingIdsListByPop(map);
                if (shareActivity != null) {
                    String bizIds = shareActivity.getBizIds();
                    String[] ids = bizIds.split(",");//从对象中获取的id集合
                    System.out.println("遍历ids数组============" + Arrays.toString(ids));
                    if (shareActivity.getMatchType() == (byte) 2) {//1sku，2spu，3店铺id，4通天塔id',pop只判断2和3
                        headers = new String[]{"序号", "spu", "sku"};
                        columns = new String[]{"serialId", "spuId", "id"};
                        int size = ids.length;//对象id集合中的id个数
                        int num = size / 99;//循环的次数，调用jsf接口，传递参数的集合个数每次不能超过99
                        int yu = size % 99;//余数是不是0，下面判断循环的次数
                        if (yu != 0) {//有余数循环次数+1
                            num = num + 1;
                        }
                        Map<Long, String> mapskuAll = new HashMap<Long, String>();
                        if (num > 1) {//多次调用jsf
                            for (int i = 0; i < num; i++) {//循环调用jsf
                                Set setspuids = new HashSet<Long>();
                                if (i != num - 1) {
                                    for (int j = i * 99; j < (i + 1) * 99; j++) {
                                        setspuids.add(Long.valueOf(ids[j]));
                                    }
                                } else {//最后一次
                                    for (int j = (num - 1) * 99; j < size; j++) {
                                        setspuids.add(Long.valueOf(ids[j]));
                                    }
                                }
                                for (Object value : setspuids) {
                                    System.out.print((long) value);
                                }
                                Map<Long, String> mapsku = myProduceService.spuToSkus(setspuids);//通过spu转化为sku
                                mapskuAll.putAll(mapsku);
                            }
                        } else {//只调用一次jsf
                            Set setspuids = new HashSet<Long>();
                            for (String id : ids) {
                                setspuids.add(Long.valueOf(id));
                            }
                            Map<Long, String> mapsku = myProduceService.spuToSkus(setspuids);//通过spu转化为sku
                            mapskuAll.putAll(mapsku);
                        }
                        for (String id : ids) {//id=spu,遍历jsf返回的sku结果，添加到list中
                            String skuId = mapskuAll.get(Long.valueOf(id));
                            if (skuId.contains(",")) {//spu对应多个sku
                                String skuid[] = skuId.split(",");
                                for (String id1 : skuid) {
                                    IdsAndAuditStatus idsAndAuditStatus = new IdsAndAuditStatus();
                                    idsAndAuditStatus.setId(id1);
                                    idsAndAuditStatus.setSpuId(id);
                                    IdsAndAuditStatusList.add(idsAndAuditStatus);
                                }
                            } else {
                                IdsAndAuditStatus idsAndAuditStatus = new IdsAndAuditStatus();
                                idsAndAuditStatus.setId(skuId);
                                idsAndAuditStatus.setSpuId(id);
                                IdsAndAuditStatusList.add(idsAndAuditStatus);
                            }
                        }
                    }
                    if (shareActivity.getMatchType() == (byte) 3) {//店铺直接转化为id,1sku，2spu，3店铺id，4通天塔id',pop只判断2和3
                        headers = new String[]{"序号", "sku"};
                        columns = new String[]{"serialId", "id"};
                        for (String id : ids) {
                            IdsAndAuditStatus idsAndAuditStatus = new IdsAndAuditStatus();
                            idsAndAuditStatus.setId(id);
                            IdsAndAuditStatusList.add(idsAndAuditStatus);
                        }
                    }
                }
                break;
            case 1:
                headers = new String[]{"序号", "sku", "审核失败原因"};
                columns = new String[]{"serialId", "id", "auditStatus"};
                IdsAndAuditStatusList = shareActivityCommonService.getThingIdsListByOperation(map);
                break;
            default:
                break;
        }
        String title = "活动" + activityId + "对应的商品ID";
        try {
            if (IdsAndAuditStatusList != null && IdsAndAuditStatusList.size() > 5000) {//多个sheet
                Workbook workbook = BatchExportToExcelUtil.createMoreWorkBook(title, headers, IdsAndAuditStatusList.size());
                workbook = BatchExportToExcelUtil.exportMoreExcel(workbook, columns, IdsAndAuditStatusList, null);
                export(workbook, title, response);
            } else {//一个sheet
                Workbook workbook = BatchExportToExcelUtil.createWorkBook(title, headers);
                workbook = BatchExportToExcelUtil.exportExcel(workbook, columns, IdsAndAuditStatusList, null);
                export(workbook, title, response);
            }
        } catch (Exception e) {
        }
    }


    /**
     * 按日期分组——采销 by lipengcheng 2018.8.10
     *
     * @param startDate      开始时间
     * @param endDate        结束时间
     * @param bizType        类型：1、商详；2、店铺；3、通天塔
     * @param activityId     活动id
     * @param status         活动状态：0未开始，1正在进行，2已经结束，
     * @param firstCategory  一级分类
     * @param secondCategory 二级分类
     * @param thirdCategory  三级分类
     * @param erp            erp账号
     * @param sortFiled      排序字段（1：分享成功次数  2：打开UV  3：引入订单量  4：引入订单金额 ）
     * @param sortValue      排序值（1 升序  2 降序）
     */
    @RequestMapping(value = "/excelDataListByDate.do", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public void excelDataListByDate(HttpServletRequest request, HttpServletResponse response, Long startDate, Long endDate, Integer bizType, Long activityId, Integer status,
                                    Integer firstCategory, Integer secondCategory, Integer thirdCategory, Integer sortFiled, Integer sortValue, String erp) {
        System.out.println("按日期分组—Excel—采销参数================?startDate=" + startDate + "&endDate=" + endDate + "&firstCategory=" + firstCategory
                + "&secondCategory=" + secondCategory + "&thirdCategory=" + thirdCategory + "&bizType=" + bizType + "&activityId=" + activityId + "&status=" + status + "&sortFiled=" + sortFiled + "&sortValue=" + sortValue + "&erp=" + erp);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        map.put("bizType", bizType);
        map.put("activityId", activityId);
        map.put("status", status);
        map.put("sortFiled", sortFiled);
        map.put("sortValue", sortValue);
        map.put("firstCategory", firstCategory);
        map.put("secondCategory", secondCategory);
        map.put("thirdCategory", thirdCategory);
        map.put("creatorList", null);
        map.put("groupby", 1);//是否分组：1-查列表；null-求和
        //判断查询时间是否超过六个月
        //boolean timeout = ifTimeOut(startDate, endDate); //true-超时，false-正常查询
        //获取当前人
        List<ActivityDataStatisticalExtend> activityDataStatisticalList = new ArrayList<ActivityDataStatisticalExtend>();
        UserVo userVo = loginService.getUserInfFromCookie(request);
        if (userVo != null ) {
            //获取下两级的采销人员
            List<String> creatorList = loginService.getUsers(userVo);
            if (creatorList != null && creatorList.size() > 0) {
                map.put("creatorList", creatorList);
            }
            activityDataStatisticalList = excelJsfService.getDataListByDate(map);
            DateContinue(activityDataStatisticalList);
            System.out.println("时间连续后的list大小="+activityDataStatisticalList.size());

        }
//        String[] headers = {"序号", "日期", "页面UV", "分享有礼点击UV", "总分享次数", "总分享UV", "打开次数", "打开UV", "引入dau", "活动数量", "引入订单数量", "引入订单金额", "有效订单数量", "有效订单金额","完成订单数量", "完成订单金额","用户使用优惠券数量", "用户京豆使用数量"};
        String[] headers = {"序号", "日期", "页面UV" };
//        String[] columns = {"serialId", "statisticalTime", "pageUv", "clickNumberUv", "clickSuccessUv", "shareSuccessUv", "openNumber", "openSuccessUv", "importDau", "activityNum", "orderNumber", "orderAmount","actualOrderNumber", "actualOrderAmount","DoneOrderNumber", "DoneOrderAmount", "couponUsedAmount", "beanUsedAmount"};
        String[] columns = {"serialId", "statisticalTime", "pageUv"};
        Map<String, BigDecimal> columnssum = new HashMap<String, BigDecimal>();//传递求和的字段
        columnssum.put("pageUv", new BigDecimal(0));
        /*columnssum.put("clickNumberUv", new BigDecimal(0));
        columnssum.put("clickSuccessUv", new BigDecimal(0));
        columnssum.put("shareSuccessUv", new BigDecimal(0));
        columnssum.put("openNumber", new BigDecimal(0));
        columnssum.put("openSuccessUv", new BigDecimal(0));
        columnssum.put("importDau", new BigDecimal(0));
        columnssum.put("activityNum", new BigDecimal(0));
        columnssum.put("orderNumber", new BigDecimal(0));
        columnssum.put("orderAmount", new BigDecimal(0));
        columnssum.put("actualOrderNumber", new BigDecimal(0));
        columnssum.put("actualOrderAmount", new BigDecimal(0));
        columnssum.put("DoneOrderNumber", new BigDecimal(0));
        columnssum.put("DoneOrderAmount", new BigDecimal(0));
        columnssum.put("couponUsedAmount", new BigDecimal(0));
        columnssum.put("beanUsedAmount", new BigDecimal(0));*/
        String title = "数据看板-采销侧日期报表";
        Workbook workbook = BatchExportToExcelUtil.createWorkBook(title, headers);
        try {
            workbook = BatchExportToExcelUtil.exportExcel(workbook, columns, activityDataStatisticalList, columnssum);
        } catch (Exception e) {
            log.error("导出报表 error:" + e.getMessage());
        }
        export(workbook, title, response);
    }


    /**
     * 按活动分组——采销 by lipengcheng 2018.8.14
     *
     * @param startDate      开始时间
     * @param endDate        结束时间
     * @param bizType        类型：1、商详；2、店铺；3、通天塔
     * @param activityId     活动id
     * @param status         活动状态：0未开始，1正在进行，2已经结束，
     * @param erp            erp账号
     * @param sortFiled      排序字段（1：分享成功次数  2：打开UV  3：引入订单量  4：引入订单金额 ）
     * @param sortValue      排序值（1 升序  2 降序）
     * @param firstCategory  一级分类
     * @param secondCategory 二级分类
     * @param thirdCategory  三级分类
     */
    @RequestMapping(value = "/excelActivityListByDate.do", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public void excelActivityListByDate(HttpServletRequest request, HttpServletResponse response, Long startDate, Long endDate, Integer bizType, Long activityId, Integer status, Integer sortFiled, Integer sortValue, String erp,
                                        Integer firstCategory, Integer secondCategory, Integer thirdCategory) {
        System.out.println("按活动分组—Excel—采销参数================?startDate=" + startDate + "&endDate=" + endDate + "&firstCategory=" + firstCategory + sortFiled + "&sortValue=" + sortValue + "&erp=" + erp
                + "&secondCategory=" + secondCategory + "&thirdCategory=" + thirdCategory + "&bizType=" + bizType + "&activityId=" + activityId + "&status=" + status);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        map.put("bizType", bizType);
        map.put("activityId", activityId);
        map.put("status", status);
        map.put("erp", erp);
        map.put("sortFiled", sortFiled);
        map.put("sortValue", sortValue);
        map.put("firstCategory", firstCategory);
        map.put("secondCategory", secondCategory);
        map.put("thirdCategory", thirdCategory);
        map.put("creatorList", null);
        map.put("groupby", 1);//是否分组：1-查列表；null-求和
        //判断查询时间是否超过六个月
//        boolean timeout = ifTimeOut(startDate, endDate); //true-超时，false-正常查询
        //获取当前人
        List<ActivityDataStatisticalExtend> activityDataStatisticalList = new ArrayList<ActivityDataStatisticalExtend>();
        UserVo userVo = loginService.getUserInfFromCookie(request);
        if (userVo != null ) {
            //获取下两级的采销人员
            List<String> creatorList = loginService.getUsers(userVo);
            if (creatorList != null && creatorList.size() > 0) {
                map.put("creatorList", creatorList);
            }
            activityDataStatisticalList = excelJsfService.getActivityListByDate(map);
        }
        String[] headers = {"序号", "活动名称", "活动id", "创建人", "活动入口", "页面UV", "分享有礼点击UV", "分享次数", "打开次数", "打开UV", "引入订单量", "引入订单金额", "有效订单数量", "有效订单金额","完成订单数量", "完成订单金额", "用户使用优惠券数量", "用户使用京豆数量"};
        String[] columns = {"serialId", "activityName", "activityId", "creator", "bizTypeName", "pageUv", "clickNumberUv", "clickSuccessUv", "openNumber", "openSuccessUv", "orderNumber", "orderAmount","actualOrderNumber", "actualOrderAmount","DoneOrderNumber", "DoneOrderAmount", "couponUsedAmount", "beanUsedAmount"};
        Map<String, BigDecimal> columnssum = new HashMap<String, BigDecimal>();//传递求和的字段
        columnssum.put("pageUv", new BigDecimal(0));
        columnssum.put("clickNumberUv", new BigDecimal(0));
        columnssum.put("clickSuccessUv", new BigDecimal(0));
        columnssum.put("openNumber", new BigDecimal(0));
        columnssum.put("openSuccessUv", new BigDecimal(0));
        columnssum.put("orderNumber", new BigDecimal(0));
        columnssum.put("orderAmount", new BigDecimal(0));
        columnssum.put("actualOrderNumber", new BigDecimal(0));
        columnssum.put("actualOrderAmount", new BigDecimal(0));
        columnssum.put("DoneOrderNumber", new BigDecimal(0));
        columnssum.put("DoneOrderAmount", new BigDecimal(0));
        columnssum.put("couponUsedAmount", new BigDecimal(0));
        columnssum.put("beanUsedAmount", new BigDecimal(0));
        String title = "数据看板-采销侧活动报表";
        Workbook workbook = BatchExportToExcelUtil.createWorkBook(title, headers);
        try {
            workbook = BatchExportToExcelUtil.exportExcel(workbook, columns, activityDataStatisticalList, columnssum);
        } catch (Exception e) {
            log.error("导出报表 error:" + e.getMessage());
        }
        export(workbook, title, response);
    }

    /**
     * 查看sku的数据列表——采销 by  lipengchneg 2018.8.20
     *
     * @param queryDate  查询日期
     * @param activityId 活动id
     * @param bizId      spu或者店铺id
     * @param firstCategory  一级分类
     * @param secondCategory 二级分类
     * @param thirdCategory  三级分类
     * @param sortFiled  排序字段（1：分享次数   2：引入订单金额   3：引入订单量   4：打开uv   5：dau）
     * @param sortValue  排序值（1 升序  2 降序）
     */
    @RequestMapping(value = "/excelBizList.do", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public void excelBizList(HttpServletResponse response, Long queryDate, Long activityId, String bizId, Integer sortFiled, Integer sortValue, Integer firstCategory, Integer secondCategory, Integer thirdCategory) {
//        if (queryDate == null) {
//            return;
//        }
//        if (activityId == null) {
//            return;
//        }
        System.out.println("查看sku的数据列表—Excel—采销参数========?queryDate=" + queryDate + "&activityId=" + activityId + "&bizId=" + bizId+ "&firstCategory=" + firstCategory
                + "&secondCategory=" + secondCategory + "&thirdCategory=" + thirdCategory );
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("queryDate", queryDate);
        map.put("activityId", activityId);
        map.put("bizId", bizId);
        map.put("firstCategory", firstCategory);
        map.put("secondCategory", secondCategory);
        map.put("thirdCategory", thirdCategory);
        map.put("sortFiled", sortFiled);
        map.put("sortValue", sortValue);
        List<ActivityDataStatisticalExtend> activityDataStatisticaList = excelJsfService.getBizList(map);
        String[] headers = {"序号", "商品id", "入口", "页面UV", "分享有礼点击UV", "分享次数", "分享UV", "打开次数", "打开UV", "平均每个分享者引流人数", "分享引入订单量", "分享引入订单金额", "用户使用优惠券数量", "用户使用京豆数量"};
        String[] columns = {"serialId", "bizid", "bizTypeName", "pageUv", "clickNumberUv", "clickSuccessUv", "shareSuccessUv", "openNumber", "openSuccessUv", "drainageAvgNum", "orderNumber", "orderAmount", "couponUsedAmount", "beanUsedAmount"};
        Map<String, BigDecimal> columnssum = new HashMap<String, BigDecimal>();//传递求和的字段
        columnssum.put("pageUv", new BigDecimal(0));
        columnssum.put("clickNumberUv", new BigDecimal(0));
        columnssum.put("clickSuccessUv", new BigDecimal(0));
        columnssum.put("shareSuccessUv", new BigDecimal(0));
        columnssum.put("openNumber", new BigDecimal(0));
        columnssum.put("openSuccessUv", new BigDecimal(0));
        columnssum.put("drainageAvgNum", new BigDecimal(0));
        columnssum.put("orderNumber", new BigDecimal(0));
        columnssum.put("orderAmount", new BigDecimal(0));
        columnssum.put("couponUsedAmount", new BigDecimal(0));
        columnssum.put("beanUsedAmount", new BigDecimal(0));
        String title = "数据看板-采销侧sku报表";
        Workbook workbook = BatchExportToExcelUtil.createWorkBook(title, headers);
        try {
            workbook = BatchExportToExcelUtil.exportExcel(workbook, columns, activityDataStatisticaList, columnssum);
        } catch (Exception e) {
            log.error("导出报表 error:" + e.getMessage());
        }
        export(workbook, title, response);
    }

    /**
     * 导出订单列表——采销 by lipengcheng  2018.8.21
     * 查询订单列表
     * @param startDate  查询开始日期
     * @param endDate    查询结束日期
     * @param activityId 活动id
     *  @param  bizType    类型：1、商详；2、店铺；3、通天塔
     * @param activityStatus         活动状态：0未开始，1正在进行，2已经结束，
     * @param firstCategory  一级分类
     * @param secondCategory 二级分类
     * @param thirdCategory  三级分类
     * @param status 订单状态 0待支付 1 已支付 2 已完成
     * @param orderId  订单id
     * @param bizId      bizId
     */
    @RequestMapping(value = "/excelOrderList.do", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public void excelOrderList(HttpServletResponse response, String bizId, String orderId, Integer status,Long startDate, Long endDate, Long activityId,
                               Integer bizType,Integer activityStatus,Integer firstCategory,Integer secondCategory,Integer thirdCategory) {
        System.out.println("查看订单列表——Excel—采销参数========?orderId=" + orderId + "&status=" + status+"&startDate=" + startDate+"&endDate=" + endDate+"&activityId=" + activityId+"&bizId=" + bizId
                +"&bizType=" +bizType+"&activityStatus=" +activityStatus+"&firstCategory=" +firstCategory+"&secondCategory=" +secondCategory+"&thirdCategory=" +thirdCategory);
//        if (bizId == null&&startDate == null&&endDate == null&&activityId == null) {
//            return;
//        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        map.put("activityId", activityId);
        map.put("orderId", orderId);
        map.put("bizId", bizId);
        map.put("status", status);
        map.put("bizType", bizType);
        map.put("activityStatus", activityStatus);
        map.put("secondCategory", secondCategory);
        map.put("firstCategory", firstCategory);
        map.put("thirdCategory", thirdCategory);
        List<OrderDataVo> orderDataVoList = excelJsfService.getOrderList(map);

        String[] headers = {"序号", "下单时间", "订单id", "订单金额", "下单PIN", "订单状态"};
        String[] columns = {"serialId", "submitTime", "orderId", "amount", "pin", "statusName"};
        Map<String, BigDecimal> columnssum = new HashMap<String, BigDecimal>();//传递求和的字段
        columnssum.put("amount", new BigDecimal(0));
        String title = "订单表";
        Workbook workbook = BatchExportToExcelUtil.createWorkBook(title, headers);
        try {
            workbook = BatchExportToExcelUtil.exportExcel(workbook, columns, orderDataVoList, columnssum);
        } catch (Exception e) {
            log.error("导出报表 error:" + e.getMessage());
        }
        export(workbook, title, response);
    }

    /**
     * 查询优惠券列表数据——采销 by lipengcheng 2018.8.22
     * @param startDate  查询开始日期
     * @param endDate    查询结束日期
     * @param bizType        类型：1、商详；2、店铺；3、通天塔
     * @param activityId     活动id
     * @param status         活动状态：0未开始，1正在进行，2已经结束，
     * @param firstCategory  一级分类
     * @param secondCategory 二级分类
     * @param thirdCategory  三级分类
     *  bizType    类型 1sku，2spu，3店铺id，4通天塔id（一期只有spu，店铺）
     *  bizid      spu或店铺id
     */
    @RequestMapping(value = "/excelCouponList.do", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public void excelCouponList(HttpServletResponse response, Long startDate, Long endDate, Integer bizType, Long activityId, Integer status,
                                Integer firstCategory, Integer secondCategory, Integer thirdCategory) {
        System.out.println("优惠券列表数据——采销——导出?startDate=" + startDate + "&endDate=" + endDate + "&firstCategory=" + firstCategory+ "&status=" + status
                + "&secondCategory=" + secondCategory + "&thirdCategory=" + thirdCategory + "&bizType=" + bizType + "&activityId=" + activityId);
        Map<String, Object> map = new HashMap<String, Object>();
        if (startDate != null) {
            map.put("startDate", DateUtil.timeStamp2Date(startDate + "", "yyyy-MM-dd HH:mm:ss"));
        }
        if (endDate != null) {
            map.put("endDate", DateUtil.timeStamp2Date(endDate + "", "yyyy-MM-dd HH:mm:ss"));
        }
        map.put("bizType", bizType);
        map.put("activityId", activityId);
        map.put("status", status);
        map.put("firstCategory", firstCategory);
        map.put("secondCategory", secondCategory);
        map.put("thirdCategory", thirdCategory);
        List<CouponRecord> couponDataList = excelJsfService.getCouponList(map);
        String[] headers = {"序号", "SKUid", "订单Id", "发放券",  "券编码", "发放pin", "下单时间", "下单金额", "发放时间"};//"
        String[] columns = {"serialId", "itemId", "parentSaleOrdId", "batchId", "cpsId", "userLogAcct", "useTm", "afterPrefrAmount", "arriveAcctTm"};
        Map<String, BigDecimal> columnssum = new HashMap<String, BigDecimal>();//传递求和的字段
        columnssum.put("afterPrefrAmount", new BigDecimal(0));
        String title = "优惠券表";
        Workbook workbook = BatchExportToExcelUtil.createWorkBook(title, headers);
        try {
            workbook = BatchExportToExcelUtil.exportExcel(workbook, columns, couponDataList, columnssum);
        } catch (Exception e) {
            log.error("导出报表 error:" + e.getMessage());
        }
        export(workbook, title, response);
    }

    /**
     * 导出数据---------------------删除
     *
     * @param startDate 查询开始日期
     * @param endDate   查询结束日期
     *                  activityId 活动id
     *                  bizType    类型 1sku，2spu，3店铺id，4通天塔id（一期只有spu，店铺）
     *                  bizid      spu或店铺id
     */
    @RequestMapping(value = "/exceldataData.do", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public void exceldataData(HttpServletResponse response, Long startDate, Long endDate) {
        System.out.println("exceldataData导出?startDate" + startDate + "&endDate:" + endDate);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startDate", 1533225600000L);
        map.put("endDate", 1535990399000L);
        List<ShareActivity> couponDataList = excelJsfService.exceldataData(map);
        String[] headers = {"序号", "id",  "spu", };//"
        String[] columns = {"serialId", "id", "bizIds"};
        String title = "活动id对应spu";
        Workbook workbook = BatchExportToExcelUtil.createWorkBook(title, headers);
        try {
            workbook = BatchExportToExcelUtil.exportExcel(workbook, columns, couponDataList, null);
        } catch (Exception e) {
            log.error("导出报表 error:" + e.getMessage());
        }
        export(workbook, title, response);
    }


    /**
     * 武靖文导出数据专用 by lipengcheng 2018.09.13
     *
     * @param startDate 查询开始日期
     * @param endDate   查询结束日期
     */
    @RequestMapping(value = "/excelDate.do", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    public void excelDate(HttpServletResponse response, String  startDate, String endDate) {
        System.out.println("excelData导出?startDate" + startDate + "&endDate:" + endDate);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startDate", startDate+" 00:00:00");
        map.put("endDate", endDate+" 23:59:59");
        List<excelShareActivity> DataList = excelJsfService.excelDate(map);
        String[] headers = {"序号", "活动id",  "活动名称",  "活动入口",  "店铺id",  "商家id",  "商家pin",  "活动在线时长(h)",  "投放数量"};//"
        String[] columns = {"serialId", "id", "activity_name", "type", "shop_id", "vender_id", "creator", "status", "len"};
        String title = startDate+"到"+endDate+"活动数据";
        Workbook workbook = BatchExportToExcelUtil.createWorkBook(title, headers);
        try {
            workbook = BatchExportToExcelUtil.exportExcel(workbook, columns, DataList, null);
        } catch (Exception e) {
            log.error("导出报表 error:" + e.getMessage());
        }
        export(workbook, title, response);
    }


    //判断查询时间段是否超过半年 by lipengcheng 2018.8.8
    private boolean ifTimeOut(Long startDate, Long endDate) {
        Date dstart = new Date(startDate);   //开始时间
        Date dAfter;
        Calendar calendar = Calendar.getInstance(); //得到日历
        calendar.setTime(dstart);//把开始时间赋给日历
        calendar.add(Calendar.MONTH, +6);  //设置为后6个月
        dAfter = calendar.getTime();   //得到前6月的时间
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //设置时间格式
        String defaultEndDate = sdf.format(dAfter);    //格式化后6个月的时间
        String defaultStartDate = sdf.format(dstart); //格式化当前时间
        System.out.println("查询开始时间===========" + defaultStartDate + "后6个月时间=======" + defaultEndDate + "后6个月时间毫秒数===========" + calendar.getTimeInMillis());
        if (endDate > calendar.getTimeInMillis()) {
            return true;
        }
        return false;
    }

    public  void  DateContinue(List<ActivityDataStatisticalExtend>list){
        System.out.println(JsonUtil.write2JsonStr(list));
        if(list!=null&& list.size()>2){
            List temp=new ArrayList<ActivityDataStatisticalExtend>();
            temp.addAll(list);
            list.clear();
            ActivityDataStatisticalExtend next;
            Date dtoDate;
            Date nextDate;
            String SdtoDate;
            String SnextDate;
            int g=0;
            Calendar calendar = Calendar.getInstance();
            SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
            for (int i=0;i<temp.size();i++){
                ActivityDataStatisticalExtend dto=(ActivityDataStatisticalExtend)temp.get(i);
                list.add(dto);
                System.out.println(JsonUtil.write2JsonStr(list));
                if(i<temp.size()-1){//存在下一个元素
                    dtoDate=dto.getStatisticalTime();
                    calendar.setTime(dtoDate);
                    calendar.add(calendar.DATE,-1);//把日期往后减一天.整数往后推,负数往前移动
                    dtoDate=calendar.getTime();
                    SdtoDate=fmt.format(dtoDate);
                    System.out.println("SdtoDate="+SdtoDate);
                    next=(ActivityDataStatisticalExtend)temp.get(i+1);
                    nextDate=next.getStatisticalTime();
                    SnextDate=fmt.format(nextDate);
                    System.out.println("SnextDate="+SnextDate);
                    while(!SdtoDate.equals(SnextDate)){//判断是否和下一个对象同一天
                        g++;
                        System.out.println(g);
                        ActivityDataStatisticalExtend add=new ActivityDataStatisticalExtend();
                        add.setStatisticalTime(dtoDate);
//                        add.setClickNumber(0L);
//                        add.setClickSuccessUv(0L);
//                        add.setOpenNumber(0L);
//                        add.setOpenSuccessUv(0L);
//                        add.setImportDau(0L);
//                        add.setDrainageAvgNum(0L);
//                        add.setOrderNumber(0L);
//                        add.setOrderAmount(0L);
                        add.setPageUv(0L);
//                        add.setClickNumberUv(0L);
//                        add.setClickSuccessUv(0L);
//                        add.setShareSuccessUv(0L);
//                        add.setOpenNumber(0L);
//                        add.setOpenSuccessUv(0L);
//                        add.setImportDau(0L);
//                        add.setActivityNum(0L);
//                        add.setOrderNumber(0L);
//                        add.setOrderAmount(0L);
//                        add.setCouponUsedAmount(0L);
//                        add.setBeanUsedAmount(0L);
                        System.out.println("增加时间"+SdtoDate);
                        calendar.setTime(dtoDate);
                        calendar.add(calendar.DATE,-1);
                        dtoDate=calendar.getTime();
                        SdtoDate=fmt.format(dtoDate);
                        list.add(add);
                    }
                }
            }
        }
    }

    public  boolean sameDate(Date d1, Date d2){
        SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMdd");
        //fmt.setTimeZone(new TimeZone()); // 如果需要设置时间区域，可以在这里设置
        return fmt.format(d1).equals(fmt.format(d2));
    }



    /**
     * I/o输出
     */
    private void export(Workbook workbook, String title, HttpServletResponse response) {
        response.setContentType("application/vnd.ms-excel");
        try {
            response.setHeader("Content-Disposition", "attachment;filename="
                    + new String((title + ".xlsx").getBytes(), "iso-8859-1"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            ServletOutputStream out = response.getOutputStream();
            workbook.write(out);
            out.flush();
            out.close();
        } catch (IOException e) {
        }
    }


}
