package com.jd.bjshare.domain;

import java.io.Serializable;

/**
 * @author huanglong
 * @Description: 奖励信息
 * @date 2018/4/119:15
 */
public class RewardInf implements Serializable {

    private static final long serialVersionUID = -407078503075186280L;
    /* 奖励的唯一标示 */
    private String rewardIdentify;
    /* 奖励类型：1:优惠券，2:京豆，3:店铺积分 */
    private Integer rewardType;
    /* 京豆计划Id */
    private String beanPlanId;
    /* 奖品总量 */
    private Long prizeQuota;
    /* 每天发放奖品总量 */
    private Long prizeQuotaDay;
    /* 每次发放奖品量*/
    private Long prizeQuotaTime;
    /* 优惠券id */
    private String couponId;

    public Integer getRewardType() {
        return rewardType;
    }

    public void setRewardType(Integer rewardType) {
        this.rewardType = rewardType;
    }

    public Long getPrizeQuota() {
        return prizeQuota;
    }

    public void setPrizeQuota(Long prizeQuota) {
        this.prizeQuota = prizeQuota;
    }

    public Long getPrizeQuotaDay() {
        return prizeQuotaDay;
    }

    public void setPrizeQuotaDay(Long prizeQuotaDay) {
        this.prizeQuotaDay = prizeQuotaDay;
    }

    public Long getPrizeQuotaTime() {
        return prizeQuotaTime;
    }

    public void setPrizeQuotaTime(Long prizeQuotaTime) {
        this.prizeQuotaTime = prizeQuotaTime;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getRewardIdentify() {
        return rewardIdentify;
    }

    public void setRewardIdentify(String rewardIdentify) {
        this.rewardIdentify = rewardIdentify;
    }

    public String getBeanPlanId() {
        return beanPlanId;
    }

    public void setBeanPlanId(String beanPlanId) {
        this.beanPlanId = beanPlanId;
    }
}
