package com.jd.m.cms.bjshare.domain.po;

import java.io.Serializable;
import java.util.Date;

public class ShareActivity implements Serializable {

	private static final long serialVersionUID = -7697408703957728616L;

	private Long id;

    private String creator;

    private Date createTime;

    private Long createDate;

    private String modifier;

    private Date modifyTime;

    private Long modifyDate;

    private byte isDelete;

    private String auditor;

    private byte auditStatus;

    private Long type;

    private byte source;

    private Date startTime;

    private Long startDate;

    private Date endTime;

    private Long endDate;

    private String image;

    private Byte status;

    private byte matchType;

    private String bizIds;

    private Long shareRewardLimit;

    private Long shareRewardLimitDay;

    private Integer viewRewardLimit;

    private Integer viewRewardLimitDay;
	//店铺id
    private String shopId;

    private String activityName;
    //商家id
    private Long venderId;


    //查询创建时间开始
    private String createStartStr;
	//查询创建时间结束
    private String createEndStr;

    //创建时间str
	private String createTimeStr;
	//活动开始时间str
	private String startTimeStr;
	//活动结束时间str
	private String endTimeStr;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Long getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Long createDate) {
		this.createDate = createDate;
	}

	public String getModifier() {
		return modifier;
	}

	public void setModifier(String modifier) {
		this.modifier = modifier;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Long getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Long modifyDate) {
		this.modifyDate = modifyDate;
	}

	public byte getDelete() {
		return isDelete;
	}

	public void setDelete(byte delete) {
		isDelete = delete;
	}

	public String getAuditor() {
		return auditor;
	}

	public void setAuditor(String auditor) {
		this.auditor = auditor;
	}

	public byte getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(byte auditStatus) {
		this.auditStatus = auditStatus;
	}

	public Long getType() {
		return type;
	}

	public void setType(Long type) {
		this.type = type;
	}

	public byte getSource() {
		return source;
	}

	public void setSource(byte source) {
		this.source = source;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Long getStartDate() {
		return startDate;
	}

	public void setStartDate(Long startDate) {
		this.startDate = startDate;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Long getEndDate() {
		return endDate;
	}

	public void setEndDate(Long endDate) {
		this.endDate = endDate;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public byte getMatchType() {
		return matchType;
	}

	public void setMatchType(byte matchType) {
		this.matchType = matchType;
	}

	public String getBizIds() {
		return bizIds;
	}

	public void setBizIds(String bizIds) {
		this.bizIds = bizIds;
	}

	public Long getShareRewardLimit() {
		return shareRewardLimit;
	}

	public void setShareRewardLimit(Long shareRewardLimit) {
		this.shareRewardLimit = shareRewardLimit;
	}

	public Long getShareRewardLimitDay() {
		return shareRewardLimitDay;
	}

	public void setShareRewardLimitDay(Long shareRewardLimitDay) {
		this.shareRewardLimitDay = shareRewardLimitDay;
	}

	public Integer getViewRewardLimit() {
		return viewRewardLimit;
	}

	public void setViewRewardLimit(Integer viewRewardLimit) {
		this.viewRewardLimit = viewRewardLimit;
	}

	public Integer getViewRewardLimitDay() {
		return viewRewardLimitDay;
	}

	public void setViewRewardLimitDay(Integer viewRewardLimitDay) {
		this.viewRewardLimitDay = viewRewardLimitDay;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getCreateStartStr() {
		return createStartStr;
	}

	public void setCreateStartStr(String createStartStr) {
		this.createStartStr = createStartStr;
	}

	public String getCreateEndStr() {
		return createEndStr;
	}

	public void setCreateEndStr(String createEndStr) {
		this.createEndStr = createEndStr;
	}

	public String getCreateTimeStr() {
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}

	public String getStartTimeStr() {
		return startTimeStr;
	}

	public void setStartTimeStr(String startTimeStr) {
		this.startTimeStr = startTimeStr;
	}

	public String getEndTimeStr() {
		return endTimeStr;
	}

	public void setEndTimeStr(String endTimeStr) {
		this.endTimeStr = endTimeStr;
	}

	public Long getVenderId() {
		return venderId;
	}

	public void setVenderId(Long venderId) {
		this.venderId = venderId;
	}

	public byte getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(byte isDelete) {
		this.isDelete = isDelete;
	}

}