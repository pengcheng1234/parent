package com.jd.m.cms.bjshare.domain.po;

import java.util.Date;

public class CheckFlow {
    private Integer id;

    private Integer node;

    private String checkErp;

    private String checkComment;

    private Integer checkResult;

    private Integer activityId;

    private Byte lastCheckPerson;

    private Date createTime;

    private Date modifyTime;

    private Byte status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNode() {
        return node;
    }

    public void setNode(Integer node) {
        this.node = node;
    }

    public String getCheckErp() {
        return checkErp;
    }

    public void setCheckErp(String checkErp) {
        this.checkErp = checkErp == null ? null : checkErp.trim();
    }

    public String getCheckComment() {
        return checkComment;
    }

    public void setCheckComment(String checkComment) {
        this.checkComment = checkComment == null ? null : checkComment.trim();
    }

    public Integer getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(Integer checkResult) {
        this.checkResult = checkResult;
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Byte getLastCheckPerson() {
        return lastCheckPerson;
    }

    public void setLastCheckPerson(Byte lastCheckPerson) {
        this.lastCheckPerson = lastCheckPerson;
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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}