package com.jd.m.cms.bjshare.domain.vo;

import com.jd.m.cms.bjshare.domain.po.ShareActivity;

import java.io.Serializable;
import java.util.List;

/**
 * 创建活动入参
 */
public class AddActivityVo extends ShareActivity implements Serializable {

	private static final long serialVersionUID = -887267055943622620L;

	private List<ShareRuleVo> shareRuleList;

	private String pin;

	private String shopName;

	/**
	 * 活动类型 0： pop 1：自营(含运营)
	 */
	private Integer activityType;

	public List<ShareRuleVo> getShareRuleList() {
		return shareRuleList;
	}

	public void setShareRuleList(List<ShareRuleVo> shareRuleList) {
		this.shareRuleList = shareRuleList;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Integer getActivityType() {
		return activityType;
	}

	public void setActivityType(Integer activityType) {
		this.activityType = activityType;
	}
}
