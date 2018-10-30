package com.jd.m.cms.bjshare.dao;

import java.util.Map;

/**
 * @description: 分享任务数据
 * @author: renzhuang
 * @create: 2018-07-24 17:55
 **/
public interface ShareTaskDao {

    /**
     * 获取待领取的奖励
     *
     * @param pin
     * @return
     */
    Integer getPenddingNumber(String pin);

    /**
     * 汇总该pin作为分享者和被分享者身份，在近两个月（以当天时间计算）内所获得京豆数量总和
     * <p>
     * pin,day
     *
     * @return
     */
    Integer getBeanNumber(Map<String, Object> param);

    /**
     * 汇总该pin作为分享者和被分享者身份，在近两个月内（以当天时间计算）内所获得优惠券张数总和，包含未使用和已使用、已过期三种状态
     * <p>
     * pin,day
     *
     * @return
     */
    Integer getCouponNumber(Map<String, Object> param);
}
