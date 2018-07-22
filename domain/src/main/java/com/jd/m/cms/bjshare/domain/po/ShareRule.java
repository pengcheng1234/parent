package com.jd.m.cms.bjshare.domain.po;

import java.io.Serializable;
import java.util.Date;

public class ShareRule implements Serializable {

	private static final long serialVersionUID = -35435237075625688L;

	private Long id;

    private String creator;

    private Date createTime;

    private Long createDate;

    private String modifier;

    private Date modifyTime;

    private Long modifyDate;

    private byte isDelete;

    private Long activityId;

    private Integer rewardPerson;

    private Long rewardRuleCategory;

    private Integer rewardType;

    private Integer prizeQuota;

    private Integer prizeQuotaDay;

    private Integer prizeQuotaTime;

    private String couponId;
	//京豆计划id
    private Long beanPlanId;
    //优惠券名称
    private String couponName;

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
        this.creator = creator == null ? null : creator.trim();
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
        this.modifier = modifier == null ? null : modifier.trim();
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

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Integer getRewardPerson() {
        return rewardPerson;
    }

    public void setRewardPerson(Integer rewardPerson) {
        this.rewardPerson = rewardPerson;
    }

	public Long getRewardRuleCategory() {
		return rewardRuleCategory;
	}

	public void setRewardRuleCategory(Long rewardRuleCategory) {
		this.rewardRuleCategory = rewardRuleCategory;
	}

	public Integer getRewardType() {
        return rewardType;
    }

    public void setRewardType(Integer rewardType) {
        this.rewardType = rewardType;
    }

    public Integer getPrizeQuota() {
        return prizeQuota;
    }

    public void setPrizeQuota(Integer prizeQuota) {
        this.prizeQuota = prizeQuota;
    }

    public Integer getPrizeQuotaDay() {
        return prizeQuotaDay;
    }

    public void setPrizeQuotaDay(Integer prizeQuotaDay) {
        this.prizeQuotaDay = prizeQuotaDay;
    }

    public Integer getPrizeQuotaTime() {
        return prizeQuotaTime;
    }

    public void setPrizeQuotaTime(Integer prizeQuotaTime) {
        this.prizeQuotaTime = prizeQuotaTime;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId == null ? null : couponId.trim();
    }

	public Long getBeanPlanId() {
		return beanPlanId;
	}

	public void setBeanPlanId(Long beanPlanId) {
		this.beanPlanId = beanPlanId;
	}

	public byte getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(byte isDelete) {
		this.isDelete = isDelete;
	}

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}
}