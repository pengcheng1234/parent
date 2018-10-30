package com.jd.m.cms.bjshare.client.databoard;

import com.jd.m.cms.bjshare.common.result.ResultData;
import com.jd.m.cms.bjshare.domain.po.ActivityDataStatistical;
import com.jd.m.cms.bjshare.domain.po.ShareActivityOrderStatistics;

import java.util.Map;

/**
 * Created by LPC on 2018/6/29
 * 数据统计和分页列表展示
 */
public interface DataStatisticalJsfService {

    String  excuteSql(String sql);

    int  test(Map<String, Object> map);

    /**
     * 按日期分组查数据看板列表ALL by lipengcheng 2018.7.19
     */
    ResultData getAllDataListByDate(Map<String, Object> map);


    /**
     * 按日期分组查数据看板列表
     */
    ResultData getDataListByDate(Map<String, Object> map);

    /**
     * 按活动分组查数据看板列表
     */
    ResultData getActivityListByDate(Map<String, Object> map);


    /**
     * 按活动id分组查数据看板列表
     */
    ResultData getDataListByActivityId(Map<String, Object> map);

    /**
     * 查看sku的数据列表——采销 by  lipengchneg 2018.8.20
     */
    ResultData getBizList(Map<String, Object> map);

    /**
     * 查询订单列表
     */
    ResultData getOrderList(Map<String, Object> map);

    /**
     * 查询优惠券列表
     */
    ResultData getCouponList(Map<String, Object> map);

    int insertSelective(ActivityDataStatistical record);

    int insertOrder(ShareActivityOrderStatistics record) throws Exception ;

    ResultData getYesterdayByActivityId(Map<String, Object> map);
}
