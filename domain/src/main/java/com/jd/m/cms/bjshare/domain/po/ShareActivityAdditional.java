package com.jd.m.cms.bjshare.domain.po;

import java.util.Date;

public class ShareActivityAdditional {
    private Integer id;

    private Integer activityId;

    private String produceClassify;

    private String produceClassifyCn;

    private Byte type;

    private String shopName;

    private String reserve1;

    private String reserve2;

    private String reserve3;

    private Date createTime;

    private Byte status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public String getProduceClassify() {
        return produceClassify;
    }

    public void setProduceClassify(String produceClassify) {
        this.produceClassify = produceClassify == null ? null : produceClassify.trim();
    }

    public String getProduceClassifyCn() {
        return produceClassifyCn;
    }

    public void setProduceClassifyCn(String produceClassifyCn) {
        this.produceClassifyCn = produceClassifyCn == null ? null : produceClassifyCn.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName == null ? null : shopName.trim();
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
}