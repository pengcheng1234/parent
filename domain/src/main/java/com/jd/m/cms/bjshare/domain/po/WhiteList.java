package com.jd.m.cms.bjshare.domain.po;

import java.util.Date;

public class WhiteList {
    private Integer id;

    private String userName;

    private String userErp;

    private String deptName;

    private String telphone;

    private String role;

    private String applyUserErp;

    private String auditOpinions;

    private Integer auditResult;

    private Date openTime;

    private Date createTime;

    private Date modifyTime;

    private Integer isDelete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserErp() {
        return userErp;
    }

    public void setUserErp(String userErp) {
        this.userErp = userErp == null ? null : userErp.trim();
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public String getTelphone() {
        return telphone;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone == null ? null : telphone.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getApplyUserErp() {
        return applyUserErp;
    }

    public void setApplyUserErp(String applyUserErp) {
        this.applyUserErp = applyUserErp == null ? null : applyUserErp.trim();
    }

    public String getAuditOpinions() {
        return auditOpinions;
    }

    public void setAuditOpinions(String auditOpinions) {
        this.auditOpinions = auditOpinions == null ? null : auditOpinions.trim();
    }

    public Integer getAuditResult() {
        return auditResult;
    }

    public void setAuditResult(Integer auditResult) {
        this.auditResult = auditResult;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}