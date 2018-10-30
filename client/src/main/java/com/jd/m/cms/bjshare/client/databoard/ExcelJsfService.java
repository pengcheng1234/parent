package com.jd.m.cms.bjshare.client.databoard;

import com.github.pagehelper.PageInfo;
import com.jd.m.cms.bjshare.domain.po.ActivityDataStatistical;
import com.jd.m.cms.bjshare.domain.po.CouponRecord;
import com.jd.m.cms.bjshare.domain.po.ShareActivity;
import com.jd.m.cms.bjshare.domain.vo.ActivityDataStatisticalExtend;
import com.jd.m.cms.bjshare.domain.vo.CouponDataVo;
import com.jd.m.cms.bjshare.domain.vo.OrderDataVo;
import com.jd.m.cms.bjshare.domain.vo.export.excelShareActivity;

import java.util.Map;
import java.util.List;

/**
 *
 * Created by LPC on 2018/6/29
 * 数据统计导出的jsf接口
 */
public interface ExcelJsfService {
    /**
     * 查询订单列表
     */
    List<OrderDataVo> getOrderList(Map<String, Object> map);

    /**
     * 查询优惠券列表
     */

    List<CouponRecord> getCouponList(Map<String, Object> map);

    /**
     * 按采销侧按日期分组查数据 by lipengcheng 2018.8.10
     */
    List<ActivityDataStatisticalExtend> getDataListByDate(Map<String, Object> map);

    /**
     * 按采销侧按日期分组查数据 by lipengcheng 2018.8.14
     */
    List<ActivityDataStatisticalExtend> getActivityListByDate(Map<String, Object> map);

    /**
     * 按活动id分组查数据看板列表
     */
    PageInfo<ActivityDataStatistical> getDataListByActivityId(Map<String, Object> map);

    /**
     * 获取spu或shop级别的数据列表
     */
    List<ActivityDataStatisticalExtend> getBizList(Map<String, Object> map);

    /**
     * 获取spu或shop级别的数据列表
     */
    List<ShareActivity> exceldataData(Map<String, Object> map);

    /**
     * 武靖文导出数据专用 by lipengcheng 2018.09.13
     */
    List<excelShareActivity> excelDate(Map<String, Object> map);




}
