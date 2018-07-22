package com.jd.m.cms.bjshare.domain.vo;

/**
 * Created by LPC on 2018/7/13
 */
public class IdsAndAuditStatus {
    private  String id;//商品id
    private  String spuId;
    private String auditStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getSpuId() {
        return spuId;
    }

    public void setSpuId(String spuId) {
        this.spuId = spuId;
    }

    public void IdsAndAuditStatus(String id, String auditStatus){
        this.id=id;
        this.auditStatus=auditStatus;
    }
    public void IdsAndAuditStatus(String id){
        this.id=id;
    }
    public void IdsAndAuditStatus(){}
}
