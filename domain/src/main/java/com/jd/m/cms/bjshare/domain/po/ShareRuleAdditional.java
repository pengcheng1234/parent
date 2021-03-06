package com.jd.m.cms.bjshare.domain.po;

import java.util.Date;

public class ShareRuleAdditional {
    private Integer id;

    private Integer shareRuleId;

    private String callerCode;

    private String key;

    private String businessCode;

    private String topBusinessId;

    private String secondBusinessId;

    private String orgId;

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

    public Integer getShareRuleId() {
        return shareRuleId;
    }

    public void setShareRuleId(Integer shareRuleId) {
        this.shareRuleId = shareRuleId;
    }

    public String getCallerCode() {
        return callerCode;
    }

    public void setCallerCode(String callerCode) {
        this.callerCode = callerCode == null ? null : callerCode.trim();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode == null ? null : businessCode.trim();
    }

    public String getTopBusinessId() {
        return topBusinessId;
    }

    public void setTopBusinessId(String topBusinessId) {
        this.topBusinessId = topBusinessId == null ? null : topBusinessId.trim();
    }

    public String getSecondBusinessId() {
        return secondBusinessId;
    }

    public void setSecondBusinessId(String secondBusinessId) {
        this.secondBusinessId = secondBusinessId == null ? null : secondBusinessId.trim();
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId == null ? null : orgId.trim();
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