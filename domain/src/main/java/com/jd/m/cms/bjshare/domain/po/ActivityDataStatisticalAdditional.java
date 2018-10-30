package com.jd.m.cms.bjshare.domain.po;

import java.math.BigDecimal;
import java.util.Date;

public class ActivityDataStatisticalAdditional {

    private static final long serialVersionUID = 6480879915251221821L;
    private Integer id;

    private Integer statisticalId;

    private Integer shareSuccessUv;

    private Integer shareOpenNum;

    private Integer sharedOpenNum;

    private Integer shareOpenUv;

    private Integer sharedOpenUv;

    private String reserve1;

    private String reserve2;

    private String reserve3;

    private Date createTime;

    private Byte status;

    private Long actualOrderAmount;

    private Integer actualOrderNumber;

    private Integer firstCategory;

    private Integer secondCategory;

    private Integer thirdCategory;

    private Integer clickNumberUv;

    private Long couponOrderAmount;

    private Integer couponOrderNumber;

    private Byte activityStatus;

    private Integer activityType;

    private String shopId;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatisticalId() {
        return statisticalId;
    }

    public void setStatisticalId(Integer statisticalId) {
        this.statisticalId = statisticalId;
    }

    public Integer getShareSuccessUv() {
        return shareSuccessUv;
    }

    public void setShareSuccessUv(Integer shareSuccessUv) {
        this.shareSuccessUv = shareSuccessUv;
    }

    public Integer getShareOpenNum() {
        return shareOpenNum;
    }

    public void setShareOpenNum(Integer shareOpenNum) {
        this.shareOpenNum = shareOpenNum;
    }

    public Integer getSharedOpenNum() {
        return sharedOpenNum;
    }

    public void setSharedOpenNum(Integer sharedOpenNum) {
        this.sharedOpenNum = sharedOpenNum;
    }

    public Integer getShareOpenUv() {
        return shareOpenUv;
    }

    public void setShareOpenUv(Integer shareOpenUv) {
        this.shareOpenUv = shareOpenUv;
    }

    public Integer getSharedOpenUv() {
        return sharedOpenUv;
    }

    public void setSharedOpenUv(Integer sharedOpenUv) {
        this.sharedOpenUv = sharedOpenUv;
    }

    public String getReserve1() {
        return reserve1;
    }

    public void setReserve1(String reserve1) {
        this.reserve1 = reserve1 == null ? null : reserve1.trim();
    }

    public String getReserve2() {
        return reserve2;
    }

    public void setReserve2(String reserve2) {
        this.reserve2 = reserve2 == null ? null : reserve2.trim();
    }

    public String getReserve3() {
        return reserve3;
    }

    public void setReserve3(String reserve3) {
        this.reserve3 = reserve3 == null ? null : reserve3.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Long getActualOrderAmount() {
        return actualOrderAmount;
    }

    public void setActualOrderAmount(Long actualOrderAmount) {
        this.actualOrderAmount = actualOrderAmount;
    }

    public Integer getActualOrderNumber() {
        return actualOrderNumber;
    }

    public void setActualOrderNumber(Integer actualOrderNumber) {
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

    public Integer getClickNumberUv() {
        return clickNumberUv;
    }

    public void setClickNumberUv(Integer clickNumberUv) {
        this.clickNumberUv = clickNumberUv;
    }

    public Long getCouponOrderAmount() {
        return couponOrderAmount;
    }

    public void setCouponOrderAmount(Long couponOrderAmount) {
        this.couponOrderAmount = couponOrderAmount;
    }

    public Integer getCouponOrderNumber() {
        return couponOrderNumber;
    }

    public void setCouponOrderNumber(Integer couponOrderNumber) {
        this.couponOrderNumber = couponOrderNumber;
    }

    public Byte getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(Byte activityStatus) {
        this.activityStatus = activityStatus;
    }

    public Integer getActivityType() {
        return activityType;
    }

    public void setActivityType(Integer activityType) {
        this.activityType = activityType;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }
}