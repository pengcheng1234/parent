package com.jd.bjshare.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author huanglong
 * @Description: redis 中存储的分享活动的结构
 * @date 2018/4/1023:22
 */
public class ShareActivity implements Serializable {


    private static final long serialVersionUID = -3649549212735031025L;
    /* 商铺名称 */
    private String shopName;
    /*商家编号*/
    private String venderId;
    /*商家pin*/
    private String venderPin;
    /**活动id**/
    private Long activityId;
    /* 活动状态：0未开始，1正在进行，2已经结束*/
    private Integer status;
    /*开始时间 */
    private Date startTime;
    /* 结束时间 */
    private Date endTime;
    /* 店铺ID */
    private String shopId;
    /***渠道：1APP 2微信**/
    private String source;
    /***类型：1、商详；2、店铺；3、通天塔**/
    private Integer activityEnter;
    /* 活动规则类型：1sku，2spu，3店铺id，4通天塔id */
    private Integer matchType;
    /* 对应活动规则类型的id集合 */
    private String bizIds;
    /**1分享者分享后获奖 2分享者分享后、被分享者打开均获奖**/
    private Integer rewardRule;
    /* 分享者奖励信息 */
    private ActivityRewardRule shareRule;
    /* 被分享者奖励信息 */
    private ActivityRewardRule sharedRule;

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getActivityEnter() {
        return activityEnter;
    }

    public void setActivityEnter(Integer activityEnter) {
        this.activityEnter = activityEnter;
    }

    public Integer getMatchType() {
        return matchType;
    }

    public void setMatchType(Integer matchType) {
        this.matchType = matchType;
    }

    public String getBizIds() {
        return bizIds;
    }

    public void setBizIds(String bizIds) {
        this.bizIds = bizIds;
    }

    public Integer getRewardRule() {
        return rewardRule;
    }

    public void setRewardRule(Integer rewardRule) {
        this.rewardRule = rewardRule;
    }

    public ActivityRewardRule getShareRule() {
        return shareRule;
    }

    public void setShareRule(ActivityRewardRule shareRule) {
        this.shareRule = shareRule;
    }

    public ActivityRewardRule getSharedRule() {
        return sharedRule;
    }

    public void setSharedRule(ActivityRewardRule sharedRule) {
        this.sharedRule = sharedRule;
    }

    public String getVenderId() {
        return venderId;
    }

    public void setVenderId(String venderId) {
        this.venderId = venderId;
    }

    public String getVenderPin() {
        return venderPin;
    }

    public void setVenderPin(String venderPin) {
        this.venderPin = venderPin;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }
}
