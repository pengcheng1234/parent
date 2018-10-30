package com.jd.m.cms.bjshare.web.controller;

import com.jd.m.bjshare.databoard.service.impl.DataStatisticalJsfServiceImpl;
import com.jd.m.bjshare.databoard.service.impl.DataStatisticalJsfServiceImplTemp;
import com.jd.m.cms.bjshare.client.databoard.DataStatisticalJsfService;
import com.jd.m.cms.bjshare.common.log.TraceLog;
import com.jd.m.cms.bjshare.common.log.TraceLogFactory;
import com.jd.m.cms.bjshare.common.result.ResultCode;
import com.jd.m.cms.bjshare.common.result.ResultData;
import com.jd.m.cms.bjshare.common.utils.DateUtil;
import com.jd.m.cms.bjshare.dao.ActivityDataStatisticalAdditionalMapper;
import com.jd.m.cms.bjshare.domain.po.CouponRecord;
import com.jd.m.cms.bjshare.domain.po.CouponRecordExample;
import com.jd.m.cms.bjshare.domain.vo.UserVo;
import com.jd.m.cms.bjshare.web.service.LoginService;
import com.jd.m.njf.server.client.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoaderListener;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;
import com.jd.m.cms.bjshare.dao.CouponRecordMapper;

/**
 * @author zhangxiangwei6
 * @create 2018-04-23 15:23
 **/
@Controller
@RequestMapping("/dataStatic")
public class DataStaticController {

    private static final TraceLog log = TraceLogFactory.getTraceLog(DataStaticController.class);
    @Resource
    private DataStatisticalJsfService dataStatisticalJsfService;

    @Autowired
    private LoginService loginService;

    @Autowired
    private ActivityDataStatisticalAdditionalMapper additionalMapper;

    @Autowired
    private  CouponRecordMapper CouponRecordMapper;


    @RequestMapping(value = "/excuteSql.do", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String excuteSql() {
        String sql = "INSERT INTO activity_data_statistical VALUES (1999, 'lower1', '2018-08-02 15:59:09', '12', '2018-07-27 18:34:54', '0', '13', '1', '10', '7', '10', '2018-07-27', '1532687694000', '12', '10', '17', '10', '10', '10', '10', '10', '10', '10', '10', '10', '10');";
        String OK = dataStatisticalJsfService.excuteSql(sql);
        return OK;
    }

    /**
     * 二期时间查询合并到一个方法 by lipengcheng 2018.7.19
     *
     * @param startDate      开始时间
     * @param endDate        结束时间
     * @param bizType        类型
     * @param activityId     活动id
     * @param status         活动状态
     * @param Type           按维度显示类型，1=时间，2=商家，3=采销分类
     * @param status         活动状态
     * @param firstCategory  商品一级分类
     * @param secondCategory 商品二级分类
     * @param thirdCategory  商品三级分类
     * @param shopId         店铺id
     * @param activityType   活动类型 0:pop,1:自营
     * @param creator        创建者
     * @param sortFiled      排序字段，1：总分享次数 click_success_uv  2：总分享人数 share_success_uv  3：打开次数 open_number  4：打开UV open_success_uv   5：订单量
     *                       order_number 6：订单金额 order_amount
     * @param sortValue      升序降序，1 升序  2 降序（默认是降序）
     * @param pageNum        第几页
     * @param pageSize       每页显示数量
     */
    @RequestMapping(value = "/getAllDataListByDate.do", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getAllDataListByDate(Long startDate, Long endDate, Integer bizType, Long activityId, Integer status, @RequestParam(value = "Type", defaultValue = "1") Integer Type,
                                       Integer sortFiled, Integer sortValue, String firstCategory, String secondCategory, String thirdCategory, String shopId, Integer activityType,
                                       @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, String creator,
                                       @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        ResultData resultData = new ResultData();
        System.out.println("二期时间查询合并到一个方法getAllDataListByDate param startDate:" + startDate + "|endDate:" + endDate + "|bizType:" + bizType + "|activityId:" + activityId + "|status:" + status + "|firstCategory:" + firstCategory + "|secondCategory:" + secondCategory + "|thirdCategory:" + thirdCategory + "|Type:" + Type +
                "|creator:" + creator + "|activityType:" + activityType + "|sortFiled:" + sortFiled + "|sortValue:" + sortValue + "|pageNum:" + pageNum + "|pageSize:" + pageSize);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        map.put("bizType", bizType);
        map.put("activityId", activityId);
        map.put("status", status);
        map.put("firstCategory", firstCategory);
        map.put("secondCategory", secondCategory);
        map.put("thirdCategory", thirdCategory);
        map.put("shopId", shopId);
        map.put("activityType", activityType);
        map.put("Type", Type);
        map.put("creator", creator);
        map.put("sortFiled", sortFiled);
        map.put("sortValue", sortValue);
        map.put("pageNum", pageNum);
        map.put("pageSize", pageSize);
        try {
            resultData = dataStatisticalJsfService.getAllDataListByDate(map);
        } catch (Exception e) {
            resultData.setCode(ResultCode.sysError.getCode());
            resultData.setMessage(ResultCode.sysError.getMessage());
            e.printStackTrace();
        }
        return JsonUtil.write2JsonStr(resultData);
    }

    /**
     * 按日期分组——采销 by lipengcheng 2018.7.31
     *
     * @param startDate      开始时间
     * @param endDate        结束时间
     * @param bizType        类型：1、商详；2、店铺；3、通天塔
     * @param activityId     活动id
     * @param status         活动状态：0未开始，1正在进行，2已经结束，
     * @param firstCategory  一级分类
     * @param secondCategory 二级分类
     * @param thirdCategory  三级分类
     * @param sortFiled      排序字段（1：分享成功次数  2：打开UV  3：引入订单量  4：引入订单金额 ）
     * @param sortValue      排序值（1 升序  2 降序）
     * @param pageNum        第几页
     * @param pageSize       每页显示数量
     */
    @RequestMapping(value = "/getDataListByDate.do", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getDataListByDate(HttpServletRequest request, Long startDate, Long endDate, Integer bizType, Long activityId, Integer status,
                                    Integer firstCategory, Integer secondCategory, Integer thirdCategory, Integer sortFiled, Integer sortValue,
                                    @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                    @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        ResultData resultData = new ResultData();
        System.out.println("按日期分组——采销参数================?startDate=" + startDate + "&endDate=" + endDate + "&firstCategory=" + firstCategory
                + "&secondCategory=" + secondCategory + "&thirdCategory=" + thirdCategory + "&bizType=" + bizType + "&activityId=" + activityId + "&sortFiled=" + sortFiled + "&sortValue=" + sortValue
                + "&status=" + status + "&pageNum=" + pageNum + "&pageSize=" + pageSize);
        //判断查询时间是否超过六个月
//        boolean timeout = ifTimeOut(startDate, endDate);
//        if (timeout) {
//            System.out.println("==================按日期分组——采销侧查询的时间段超过半年");
//            resultData.setCode(ResultCode.timeError.getCode());
//            resultData.setMessage(ResultCode.timeError.getMessage());
//            return JsonUtil.write2JsonStr(resultData);
//        }
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        map.put("bizType", bizType);
        map.put("activityId", activityId);
        map.put("status", status);
        map.put("firstCategory", firstCategory);
        map.put("secondCategory", secondCategory);
        map.put("thirdCategory", thirdCategory);
        map.put("sortFiled", sortFiled);
        map.put("sortValue", sortValue);
        map.put("pageNum", pageNum);
        map.put("pageSize", pageSize);
        map.put("creatorList", null);
        map.put("groupby", 1);//是否分组：1-查列表；null-求和
        //获取当前人
        UserVo userVo = loginService.getUserInfFromCookie(request);
        if (userVo == null) {
            resultData.setCode(ResultCode.EMPTY_COOKIE.getCode());
            resultData.setMessage(ResultCode.EMPTY_COOKIE.getMessage());
            return JsonUtil.write2JsonStr(resultData);
        }
        //获取下两级的采销人员
        List<String> creatorList = loginService.getUsers(userVo);
        if (creatorList != null && creatorList.size() > 0) {
            map.put("creatorList", creatorList);
        }
        try {
            resultData = dataStatisticalJsfService.getDataListByDate(map);
        } catch (Exception e) {
            resultData.setCode(ResultCode.sysError.getCode());
            resultData.setMessage(ResultCode.sysError.getMessage());
            e.printStackTrace();
            log.error("查询按日期分组——采销异常 error:" + e.getMessage());
        }
        log.info("getDataListByDate response:" + JsonUtil.write2JsonStr(resultData));
        return JsonUtil.write2JsonStr(resultData);
    }

    /**
     * 按活动分组——采销 by lipengcheng 2018.8.13
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
     * @param pageNum        第几页
     * @param pageSize       每页显示数量
     */
    @RequestMapping(value = "/getActivityListByDate.do", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getActivityListByDate(HttpServletRequest request, Long startDate, Long endDate, Integer bizType, Long activityId, Integer status,
                                        Integer firstCategory, Integer secondCategory, Integer thirdCategory, Integer sortFiled, Integer sortValue, String erp,
                                        @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                        @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        ResultData resultData = new ResultData();
        System.out.println("按活动分组——采销参数================?startDate=" + startDate + "&endDate=" + endDate + "&firstCategory=" + firstCategory
                + "&secondCategory=" + secondCategory + "&thirdCategory=" + thirdCategory + "&bizType=" + bizType + "&activityId=" + activityId
                + "&status=" + status + "&sortFiled=" + sortFiled + "&sortValue=" + sortValue + "&erp=" + erp
                + "&pageSize=" + pageSize + "&pageNum=" + pageNum);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        map.put("bizType", bizType);
        map.put("activityId", activityId);
        map.put("status", status);
        map.put("firstCategory", firstCategory);
        map.put("secondCategory", secondCategory);
        map.put("thirdCategory", thirdCategory);
        map.put("erp", erp);
        map.put("sortFiled", sortFiled);
        map.put("sortValue", sortValue);
        map.put("pageNum", pageNum);
        map.put("pageSize", pageSize);
        map.put("creatorList", null);
        map.put("groupby", 1);//是否分组：1-查列表；null-求和
        //获取当前人
        UserVo userVo = loginService.getUserInfFromCookie(request);
        if (userVo == null) {
            resultData.setCode(ResultCode.EMPTY_COOKIE.getCode());
            resultData.setMessage(ResultCode.EMPTY_COOKIE.getMessage());
            return JsonUtil.write2JsonStr(resultData);
        }
        List<String> creatorList = new ArrayList<String>();
        boolean ifCheck = false;//是否是下两级人员
        if (userVo.getLevel() == 1) {//1-采销
            creatorList = loginService.getUsers(userVo);
            if (creatorList != null && creatorList.size() > 0) {
                if (erp != null) {
                    for (String userErp : creatorList) {
                        if (erp.equals(userErp)) {
                            ifCheck = true;
                            break;
                        }
                    }
                }
                map.put("creatorList", creatorList);
            }
//            if(!ifCheck){//页面输入的erp不是该用户的权限
//                resultData.setCode(ResultCode.success.getCode());
//                resultData.setMessage(ResultCode.success.getMessage());
//                return JsonUtil.write2JsonStr(resultData);
//            }
        } else {//0-运营
            if (erp != null) {
                creatorList.add(erp);
                map.put("creatorList", creatorList);
            }
        }
        try {
            resultData = dataStatisticalJsfService.getActivityListByDate(map);
        } catch (Exception e) {
            resultData.setCode(ResultCode.sysError.getCode());
            resultData.setMessage(ResultCode.sysError.getMessage());
            e.printStackTrace();
            log.error("查询按日期分组——采销异常 error:" + e.getMessage());
        }
        log.info("getDataListByDate response:" + JsonUtil.write2JsonStr(resultData));
        return JsonUtil.write2JsonStr(resultData);
    }


    /**
     * 查看sku的数据列表——采销 by  lipengchneg 2018.8.20
     *
     * @param queryDate      查询日期
     * @param activityId     活动id
     * @param bizId          spu或者店铺id
     * @param firstCategory  一级分类
     * @param secondCategory 二级分类
     * @param thirdCategory  三级分类
     * @param sortFiled      排序字段（1：分享次数   2：引入订单金额   3：引入订单量   4：打开uv   5：dau）
     * @param sortValue      排序值（1 升序  2 降序）
     */
    @RequestMapping(value = "/getBizList.do", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getBizList(Long queryDate, Long activityId, String bizId, Integer sortFiled, Integer sortValue, Integer firstCategory, Integer secondCategory, Integer thirdCategory,
                             @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                             @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        ResultData resultData = new ResultData();
//        if (queryDate == null) {
//            resultData.setCode(ResultCode.paramError.getCode());
//            resultData.setMessage("查询时间为空");
//            return JsonUtil.write2JsonStr(resultData);
//        }
//        if (activityId == null) {
//            resultData.setCode(ResultCode.paramError.getCode());
//            resultData.setMessage("activityId为空");
//            return JsonUtil.write2JsonStr(resultData);
//        }
        System.out.println("查看sku的数据列表——采销参数========?queryDate=" + queryDate + "&activityId=" + activityId + "&bizid=" + bizId + "&sortFiled=" + sortFiled + "&sortValue=" + sortValue + "&firstCategory=" + firstCategory
                + "&secondCategory=" + secondCategory + "&thirdCategory=" + thirdCategory);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("queryDate", queryDate);
        map.put("activityId", activityId);
        map.put("bizId", bizId);
        map.put("firstCategory", firstCategory);
        map.put("secondCategory", secondCategory);
        map.put("thirdCategory", thirdCategory);
        map.put("sortFiled", sortFiled);
        map.put("sortValue", sortValue);
        map.put("pageNum", pageNum);
        map.put("pageSize", pageSize);
        try {
            resultData = dataStatisticalJsfService.getBizList(map);
        } catch (Exception e) {
            resultData.setCode(ResultCode.sysError.getCode());
            resultData.setMessage(ResultCode.sysError.getMessage());
            e.printStackTrace();
            log.error("获取sku的数据列表——采销列表异常:" + e.getMessage());
        }
        return JsonUtil.write2JsonStr(resultData);
    }


    /**
     * 查询订单列表——采销 by lipengcheng  2018.8.21
     *
     * @param startDate      查询开始日期
     * @param endDate        查询结束日期
     * @param activityId     活动idv
     * @param bizType        类型：1、商详；2、店铺；3、通天塔
     * @param activityStatus 活动状态：0未开始，1正在进行，2已经结束，
     * @param firstCategory  一级分类
     * @param secondCategory 二级分类
     * @param thirdCategory  三级分类
     * @param status         订单状态 0待支付 1 已支付 2 已完成
     * @param orderId        订单id
     * @param bizId          bizId
     */
    @RequestMapping(value = "/getOrderList.do", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getOrderList(Long startDate, Long endDate, Long activityId, String bizId, String orderId, Integer status,
                               Integer bizType, Integer activityStatus, Integer firstCategory, Integer secondCategory, Integer thirdCategory,
                               @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                               @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        System.out.println("采销显示订单列表?orderId=" + orderId + "&status=" + status + "&startDate=" + startDate + "&endDate=" + endDate + "&activityId=" + activityId + "&bizId=" + bizId
                + "&bizType=" + bizType + "&activityStatus=" + activityStatus + "&firstCategory=" + firstCategory + "&secondCategory=" + secondCategory + "&thirdCategory=" + thirdCategory);
        ResultData resultData = new ResultData();
//        if (bizId == null&&startDate == null&&endDate == null&&activityId == null) {
//            resultData.setCode(ResultCode.paramError.getCode());
//            resultData.setMessage("必传参数有为空");
//            return JsonUtil.write2JsonStr(resultData);
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
        map.put("pageNum", pageNum);
        map.put("pageSize", pageSize);
        try {
            resultData = dataStatisticalJsfService.getOrderList(map);
        } catch (Exception e) {
            resultData.setCode(ResultCode.sysError.getCode());
            resultData.setMessage(ResultCode.sysError.getMessage());
            e.printStackTrace();
            log.error("查询采销显示订单列表异常 error:" + e.getMessage());
        }
        return JsonUtil.write2JsonStr(resultData);
    }

    /**
     * 查询优惠券列表数据——采销 by lipengcheng 2018.8.22
     *
     * @param startDate      查询开始日期
     * @param endDate        查询结束日期
     * @param bizType        类型：1、商详；2、店铺；3、通天塔
     * @param activityId     活动id
     * @param status         活动状态：0未开始，1正在进行，2已经结束，
     * @param firstCategory  一级分类
     * @param secondCategory 二级分类
     * @param thirdCategory  三级分类
     *                       bizType    类型 1sku，2spu，3店铺id，4通天塔id（一期只有spu，店铺）
     *                       bizid      spu或店铺id
     */
    @RequestMapping(value = "/getCouponList.do", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getCouponList(Long startDate, Long endDate, Integer bizType, Long activityId, Integer status,
                                Integer firstCategory, Integer secondCategory, Integer thirdCategory,
                                @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {

        System.out.println("优惠券列表数据——采销查询?startDate=" + startDate + "&endDate=" + endDate + "&firstCategory=" + firstCategory + "&status=" + status
                + "&secondCategory=" + secondCategory + "&thirdCategory=" + thirdCategory + "&bizType=" + bizType + "&activityId=" + activityId);
        ResultData resultData = new ResultData();
        //判断查询时间是否超过六个月
//        boolean timeout = ifTimeOut(startDate, endDate);
//        if (timeout) {
//            System.out.println("==================优惠券列表数据——采销查询的时间段超过半年");
//            resultData.setCode(ResultCode.timeError.getCode());
//            resultData.setMessage(ResultCode.timeError.getMessage());
//            return JsonUtil.write2JsonStr(resultData);
//        }
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
        map.put("pageNum", pageNum);
        map.put("pageSize", pageSize);
        try {
            resultData = dataStatisticalJsfService.getCouponList(map);
        } catch (Exception e) {
            resultData.setCode(ResultCode.sysError.getCode());
            resultData.setMessage(ResultCode.sysError.getMessage());
            e.printStackTrace();
            log.error("查询采销——优惠券信息列表异常 error:" + e.getMessage());
        }
        return JsonUtil.write2JsonStr(resultData);
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

    @RequestMapping(value = "/getDate.do", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getDate() {
        ResultData resultData = new ResultData();
        Map<String, Object> map = new HashMap<String, Object>();
        resultData = dataStatisticalJsfService.getYesterdayByActivityId(map);
        return JsonUtil.write2JsonStr(resultData);
    }

    /**
     * 按活动分组——采销 by lipengcheng 2018.8.13
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
     * @param pageNum        第几页
     * @param pageSize       每页显示数量
     */
    @RequestMapping(value = "/getActivityListByDateTest.do", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String getActivityListByDateTest(HttpServletRequest request, Long startDate, Long endDate, Integer bizType, Long activityId, Integer status,
                                            Integer firstCategory, Integer secondCategory, Integer thirdCategory, Integer sortFiled, Integer sortValue, String erp,
                                            @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
                                            @RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize) {
        ResultData resultData = new ResultData();
        System.out.println("按活动分组Test——采销参数Test================?startDate=" + startDate + "&endDate=" + endDate + "&firstCategory=" + firstCategory
                + "&secondCategory=" + secondCategory + "&thirdCategory=" + thirdCategory + "&bizType=" + bizType + "&activityId=" + activityId
                + "&status=" + status + "&sortFiled=" + sortFiled + "&sortValue=" + sortValue + "&erp=" + erp
                + "&pageSize=" + pageSize + "&pageNum=" + pageNum);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("startDate", startDate);
        map.put("endDate", endDate);
        map.put("bizType", bizType);
        map.put("activityId", activityId);
        map.put("status", status);
        map.put("firstCategory", firstCategory);
        map.put("secondCategory", secondCategory);
        map.put("thirdCategory", thirdCategory);
        map.put("erp", erp);
        map.put("sortFiled", sortFiled);
        map.put("sortValue", sortValue);
        map.put("pageNum", pageNum);
        map.put("pageSize", pageSize);
        map.put("creatorList", null);
        map.put("groupby", 1);//是否分组：1-查列表；null-求和
        //获取当前人
        UserVo userVo = loginService.getUserInfFromCookie(request);
        if (userVo == null) {
            resultData.setCode(ResultCode.EMPTY_COOKIE.getCode());
            resultData.setMessage(ResultCode.EMPTY_COOKIE.getMessage());
            return JsonUtil.write2JsonStr(resultData);
        }
        //获取下两级的采销人员
        List<String> creatorList = new ArrayList<String>();
        if (erp != null) {
            creatorList.add(erp);
            map.put("creatorList", creatorList);
        } else {
            creatorList = loginService.getUsers(userVo);
            if (creatorList != null && creatorList.size() > 0) {
                map.put("creatorList", creatorList);
            }
        }
        try {
            resultData = dataStatisticalJsfService.getActivityListByDate(map);
        } catch (Exception e) {
            resultData.setCode(ResultCode.sysError.getCode());
            resultData.setMessage(ResultCode.sysError.getMessage());
            e.printStackTrace();
            log.error("查询按日期分组——采销异常 error:" + e.getMessage());
        }
        log.info("getDataListByDate response:" + JsonUtil.write2JsonStr(resultData));
        return JsonUtil.write2JsonStr(resultData);
    }


    @RequestMapping(value = "/test2.do", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String test2(String date) {
        Map<String, Object> map = new HashMap<String, Object>();
        String startDate = date + " 00:00:00";
        String endDate = date + " 23:59:59";

        map.put("startDate", DateUtil.formatStringToDate(startDate, DateUtil.YYMMDDHHMMSS));
        map.put("endDate", DateUtil.formatStringToDate(endDate, DateUtil.YYMMDDHHMMSS));
        System.out.println("删除已统计的数据时间范围从" + startDate + "到" + endDate);
        DataStatisticalJsfService dataStatisticalJsfServiceImpl = (DataStatisticalJsfService) ContextLoaderListener.getCurrentWebApplicationContext().getBean("dataStatisticalJsfServiceImpl");
        System.out.println(dataStatisticalJsfServiceImpl.getClass().getDeclaringClass());
        System.out.println(dataStatisticalJsfServiceImpl.getClass().getName());
        System.out.println(ContextLoaderListener.getCurrentWebApplicationContext().getBean("dataStatisticalJsfServiceImplTemp").getClass());

        int a = dataStatisticalJsfService.test(map);
//        int  a=impl.test(map);
        return "删除了" + a + "条数据";
    }

    @RequestMapping(value = "/test.do", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String test(String date) {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        Map<String, Object> map=new HashMap<String,Object>();
        map.put("activityStatus",2);
        map.put("list",list);
        int a = additionalMapper.updateActivityStatusByIds(map);
        return "删除了" + a + "条数据";
    }

    //更新優惠券訂單活动状态
    @RequestMapping(value = "/updateCoupon.do", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String updateCoupon() {
        CouponRecord record = new CouponRecord();
        record.setStatus((byte)2);
        CouponRecordExample example = new CouponRecordExample();
        example.createCriteria().andActivityIdEqualTo(9999);
        CouponRecordMapper.updateByExampleSelective(record,example);
        return "更新了";
    }

}
