package com.jd.bjshare.domain;

/**
 * @author huanglong
 * @Description: 统计的数据结构
 * @date 2018/5/1113:57
 */
public class StaticalBean {
    /* 活动id */
    private Long activityId;
    /* 数量 */
    private Long count;
    /* 业务id */
    private String bizId;
    /**
     * 类型：1、商详；2、店铺；3、通天塔
     */
    private int bizType;
    /**
     * 商家id
     */
    private Long venderId;
    /**
     * 活动名称
     */
    private String activityName;

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public int getBizType() {
        return bizType;
    }

    public void setBizType(int bizType) {
        this.bizType = bizType;
    }

    public Long getVenderId() {
        return venderId;
    }

    public void setVenderId(Long venderId) {
        this.venderId = venderId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }
}
