package com.jd.m.statistics.domain;/**
 * Created by renzhuang on 2018/8/23.
 */

/**
 * @description: 根据统计区分的条件
 * @author: renzhuang
 * @create: 2018-08-23 11:31
 **/
public  class StatisticalKey {

    private  Integer activityId;

    private String bizid;

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getBizid() {
        return bizid;
    }

    public void setBizid(String bizid) {
        this.bizid = bizid;
    }

    public StatisticalKey(Integer activityId, String bizid) {
        this.activityId = activityId;
        this.bizid = bizid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StatisticalKey)) return false;

        StatisticalKey that = (StatisticalKey) o;

        if (!activityId.equals(that.activityId)) return false;
        return bizid.equals(that.bizid);
    }

    @Override
    public int hashCode() {
        int result = activityId.hashCode();
        result = 31 * result + bizid.hashCode();
        return result;
    }
}
