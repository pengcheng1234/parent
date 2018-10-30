package com.jd.m.cms.bjshare.domain.po;

import java.util.Date;

public class Role {
    private Integer id;

    private String userName;

    private String userErp;

    private String deptName;

    private String telphone;

    private Byte roleType;

    private String applyUserErp;

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

    public Byte getRoleType() {
        return roleType;
    }

    public void setRoleType(Byte roleType) {
        this.roleType = roleType;
    }

    public String getApplyUserErp() {
        return applyUserErp;
    }

    public void setApplyUserErp(String applyUserErp) {
        this.applyUserErp = applyUserErp == null ? null : applyUserErp.trim();
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;

        Role that = (Role) o;

        if (!userErp.equals(that.userErp)) return false;
        return userName.equals(that.userName);
    }

    @Override
    public int hashCode() {
        int result = userErp.hashCode();
        result = 31 * result + userName.hashCode();
        return result;
    }


}