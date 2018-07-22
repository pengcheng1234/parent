package com.jd.m.cms.bjshare.domain.po;

import java.util.Date;

public class OperaterList {
    private Integer id;

    private Date createTime;

    private Date modifyTime;

    private String erp;

    private String name;

    private Byte status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getErp() {
        return erp;
    }

    public void setErp(String erp) {
        this.erp = erp == null ? null : erp.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}