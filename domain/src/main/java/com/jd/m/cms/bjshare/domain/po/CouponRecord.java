package com.jd.m.cms.bjshare.domain.po;

import java.util.Date;

public class CouponRecord {
    private Integer id;

    private Long batchId;

    private Integer cpsTypeCd;

    private Integer cpsCateCd;

    private Date useTm;

    private String parentSaleOrdId;

    private String userLogAcct;

    private Date arriveAcctTm;

    private String channelName;

    private String activityName;

    private String pageClickKey;

    private Double cpsFaceValue;

    private Double consumeLim;

    private String saleOrdId;

    private Long itemId;

    private Integer itemFirstCateCd;

    private Integer itemSecondCateCd;

    private Integer itemThirdCateCd;

    private Double beforePrefrAmount;

    private Double afterPrefrAmount;

    private Date createTime;

    private Date statisticalTime;

    private Integer activityId;

    private String cpsId;

    private Date cpsValidBeginTm;

    private Date cpsValidEndTm;

    private Byte status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getBatchId() {
        return batchId;
    }

    public void setBatchId(Long batchId) {
        this.batchId = batchId;
    }

    public Integer getCpsTypeCd() {
        return cpsTypeCd;
    }

    public void setCpsTypeCd(Integer cpsTypeCd) {
        this.cpsTypeCd = cpsTypeCd;
    }

    public Integer getCpsCateCd() {
        return cpsCateCd;
    }

    public void setCpsCateCd(Integer cpsCateCd) {
        this.cpsCateCd = cpsCateCd;
    }

    public Date getUseTm() {
        return useTm;
    }

    public void setUseTm(Date useTm) {
        this.useTm = useTm;
    }

    public String getParentSaleOrdId() {
        return parentSaleOrdId;
    }

    public void setParentSaleOrdId(String parentSaleOrdId) {
        this.parentSaleOrdId = parentSaleOrdId == null ? null : parentSaleOrdId.trim();
    }

    public String getUserLogAcct() {
        return userLogAcct;
    }

    public void setUserLogAcct(String userLogAcct) {
        this.userLogAcct = userLogAcct == null ? null : userLogAcct.trim();
    }

    public Date getArriveAcctTm() {
        return arriveAcctTm;
    }

    public void setArriveAcctTm(Date arriveAcctTm) {
        this.arriveAcctTm = arriveAcctTm;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName == null ? null : channelName.trim();
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName == null ? null : activityName.trim();
    }

    public String getPageClickKey() {
        return pageClickKey;
    }

    public void setPageClickKey(String pageClickKey) {
        this.pageClickKey = pageClickKey == null ? null : pageClickKey.trim();
    }

    public Double getCpsFaceValue() {
        return cpsFaceValue;
    }

    public void setCpsFaceValue(Double cpsFaceValue) {
        this.cpsFaceValue = cpsFaceValue;
    }

    public Double getConsumeLim() {
        return consumeLim;
    }

    public void setConsumeLim(Double consumeLim) {
        this.consumeLim = consumeLim;
    }

    public String getSaleOrdId() {
        return saleOrdId;
    }

    public void setSaleOrdId(String saleOrdId) {
        this.saleOrdId = saleOrdId == null ? null : saleOrdId.trim();
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Integer getItemFirstCateCd() {
        return itemFirstCateCd;
    }

    public void setItemFirstCateCd(Integer itemFirstCateCd) {
        this.itemFirstCateCd = itemFirstCateCd;
    }

    public Integer getItemSecondCateCd() {
        return itemSecondCateCd;
    }

    public void setItemSecondCateCd(Integer itemSecondCateCd) {
        this.itemSecondCateCd = itemSecondCateCd;
    }

    public Integer getItemThirdCateCd() {
        return itemThirdCateCd;
    }

    public void setItemThirdCateCd(Integer itemThirdCateCd) {
        this.itemThirdCateCd = itemThirdCateCd;
    }

    public Double getBeforePrefrAmount() {
        return beforePrefrAmount;
    }

    public void setBeforePrefrAmount(Double beforePrefrAmount) {
        this.beforePrefrAmount = beforePrefrAmount;
    }

    public Double getAfterPrefrAmount() {
        return afterPrefrAmount;
    }

    public void setAfterPrefrAmount(Double afterPrefrAmount) {
        this.afterPrefrAmount = afterPrefrAmount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getStatisticalTime() {
        return statisticalTime;
    }

    public void setStatisticalTime(Date statisticalTime) {
        this.statisticalTime = statisticalTime;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getCpsId() {
        return cpsId;
    }

    public void setCpsId(String cpsId) {
        this.cpsId = cpsId == null ? null : cpsId.trim();
    }

    public Date getCpsValidBeginTm() {
        return cpsValidBeginTm;
    }

    public void setCpsValidBeginTm(Date cpsValidBeginTm) {
        this.cpsValidBeginTm = cpsValidBeginTm;
    }

    public Date getCpsValidEndTm() {
        return cpsValidEndTm;
    }

    public void setCpsValidEndTm(Date cpsValidEndTm) {
        this.cpsValidEndTm = cpsValidEndTm;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}