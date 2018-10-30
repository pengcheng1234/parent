package com.jd.m.cms.bjshare.domain.vo;

import com.jd.m.cms.bjshare.domain.po.ActivityDataStatistical;

import java.io.Serializable;

/**
 * Created by LPC on 2018/7/23
 */
public class ActivityDataStatisticalExtend extends ActivityDataStatistical implements Serializable {
    private static final long serialVersionUID = 6480879915251528821L;

    private String  couponUsage;//卷的使用率

    private Long shopOrErpSum;//参与店铺/ERP数量总数

    private Long goodsNum;//涉及商品数量

    private Long  activityNum;//活动总数量

    private Long shareSuccessUv;//分享成功uv

    private Long  shareOpenNum;//分享者打开次数

    private Long sharedOpenNum;//被分享者打开次数

    private Long shareOpenUv;//分享者打开uv

    private Long sharedOpenUv;//被分享者打开uv

    private Long actualOrderAmount;//实际订单金额

    private Long actualOrderNumber;//实际订单数量

    private Integer  firstCategory;//一级分类

    private Integer secondCategory;//二级分类

    private Integer thirdCategory;//三级分类

    private Long clickNumberUv;//分享有礼icon点击uv

    private Long couponOrderAmount;//使用券引入的订单金额

    private  Long couponOrderNumber;//使用券引入的订单数量

    private String  bizTypeName;//活动入口 2018.8.14


    private Integer DoneOrderNumber;

    private Long DoneOrderAmount;

    public Integer getDoneOrderNumber() {
        return DoneOrderNumber;
    }

    public void setDoneOrderNumber(Integer doneOrderNumber) {
        DoneOrderNumber = doneOrderNumber;
    }

    public Long getDoneOrderAmount() {
        return DoneOrderAmount;
    }

    public void setDoneOrderAmount(Long doneOrderAmount) {
        DoneOrderAmount = doneOrderAmount;
    }

    public String getBizTypeName() {
        return bizTypeName;
    }

    public void setBizTypeName(String bizTypeName) {
        this.bizTypeName = bizTypeName;
    }

    public String getCouponUsage() {
        return couponUsage;
    }

    public void setCouponUsage(String couponUsage) {
        this.couponUsage = couponUsage;
    }

    public Long getShopOrErpSum() {
        return shopOrErpSum;
    }

    public void setShopOrErpSum(Long shopOrErpSum) {
        this.shopOrErpSum = shopOrErpSum;
    }

    public Long getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Long goodsNum) {
        this.goodsNum = goodsNum;
    }

    public Long getActivityNum() {
        return activityNum;
    }

    public void setActivityNum(Long activityNum) {
        this.activityNum = activityNum;
    }

    public Long getShareSuccessUv() {
        return shareSuccessUv;
    }

    public void setShareSuccessUv(Long shareSuccessUv) {
        this.shareSuccessUv = shareSuccessUv;
    }

    public Long getShareOpenNum() {
        return shareOpenNum;
    }

    public void setShareOpenNum(Long shareOpenNum) {
        this.shareOpenNum = shareOpenNum;
    }

    public Long getSharedOpenNum() {
        return sharedOpenNum;
    }

    public void setSharedOpenNum(Long sharedOpenNum) {
        this.sharedOpenNum = sharedOpenNum;
    }

    public Long getShareOpenUv() {
        return shareOpenUv;
    }

    public void setShareOpenUv(Long shareOpenUv) {
        this.shareOpenUv = shareOpenUv;
    }

    public Long getSharedOpenUv() {
        return sharedOpenUv;
    }

    public void setSharedOpenUv(Long sharedOpenUv) {
        this.sharedOpenUv = sharedOpenUv;
    }

    public Long getActualOrderAmount() {
        return actualOrderAmount;
    }

    public void setActualOrderAmount(Long actualOrderAmount) {
        this.actualOrderAmount = actualOrderAmount;
    }

    public Long getActualOrderNumber() {
        return actualOrderNumber;
    }

    public void setActualOrderNumber(Long actualOrderNumber) {
        this.actualOrderNumber = actualOrderNumber;
    }

    public Integer getFirstCategory() {
        return firstCategory;
    }

    public void setFirstCategory(Integer firstCategory) {
        this.firstCategory = firstCategory;
    }

    public Integer getSecondCategory() {
        return secondCategory;
    }

    public void setSecondCategory(Integer secondCategory) {
        this.secondCategory = secondCategory;
    }

    public Integer getThirdCategory() {
        return thirdCategory;
    }

    public void setThirdCategory(Integer thirdCategory) {
        this.thirdCategory = thirdCategory;
    }

    public Long getClickNumberUv() {
        return clickNumberUv;
    }

    public void setClickNumberUv(Long clickNumberUv) {
        this.clickNumberUv = clickNumberUv;
    }

    public Long getCouponOrderAmount() {
        return couponOrderAmount;
    }

    public void setCouponOrderAmount(Long couponOrderAmount) {
        this.couponOrderAmount = couponOrderAmount;
    }

    public Long getCouponOrderNumber() {
        return couponOrderNumber;
    }

    public void setCouponOrderNumber(Long couponOrderNumber) {
        this.couponOrderNumber = couponOrderNumber;
    }
}
