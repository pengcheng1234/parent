package com.jd.m.cms.bjshare.domain.po;

import java.util.Date;

public class SelfItemCate {
    private Integer id;

    private String salerErpAcct;

    private String saleStafName;

    private Integer itemFirstCateCd;

    private String itemFirstCateName;

    private Integer itemSecondCateCd;

    private String itemSecondCateName;

    private Integer itemThirdCateCd;

    private String itemThirdCateName;

    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSalerErpAcct() {
        return salerErpAcct;
    }

    public void setSalerErpAcct(String salerErpAcct) {
        this.salerErpAcct = salerErpAcct == null ? null : salerErpAcct.trim();
    }

    public String getSaleStafName() {
        return saleStafName;
    }

    public void setSaleStafName(String saleStafName) {
        this.saleStafName = saleStafName == null ? null : saleStafName.trim();
    }

    public Integer getItemFirstCateCd() {
        return itemFirstCateCd;
    }

    public void setItemFirstCateCd(Integer itemFirstCateCd) {
        this.itemFirstCateCd = itemFirstCateCd;
    }

    public String getItemFirstCateName() {
        return itemFirstCateName;
    }

    public void setItemFirstCateName(String itemFirstCateName) {
        this.itemFirstCateName = itemFirstCateName == null ? null : itemFirstCateName.trim();
    }

    public Integer getItemSecondCateCd() {
        return itemSecondCateCd;
    }

    public void setItemSecondCateCd(Integer itemSecondCateCd) {
        this.itemSecondCateCd = itemSecondCateCd;
    }

    public String getItemSecondCateName() {
        return itemSecondCateName;
    }

    public void setItemSecondCateName(String itemSecondCateName) {
        this.itemSecondCateName = itemSecondCateName == null ? null : itemSecondCateName.trim();
    }

    public Integer getItemThirdCateCd() {
        return itemThirdCateCd;
    }

    public void setItemThirdCateCd(Integer itemThirdCateCd) {
        this.itemThirdCateCd = itemThirdCateCd;
    }

    public String getItemThirdCateName() {
        return itemThirdCateName;
    }

    public void setItemThirdCateName(String itemThirdCateName) {
        this.itemThirdCateName = itemThirdCateName == null ? null : itemThirdCateName.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}