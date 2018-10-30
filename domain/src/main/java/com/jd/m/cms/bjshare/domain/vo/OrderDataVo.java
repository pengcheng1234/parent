package com.jd.m.cms.bjshare.domain.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zhangxiangwei6
 * @create 2018-04-24 15:05
 **/
public class OrderDataVo implements Serializable {

	private static final long serialVersionUID = -3364347597118171042L;

	private Long activityId;

	private String orderId;

	private Date submitTime;

	private Long submitDate;

	private String pin;

	private BigDecimal amount;

	private  String  statusName;

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	public Long getActivityId() {
		return activityId;
	}

	public void setActivityId(Long activityId) {
		this.activityId = activityId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Date getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(Date submitTime) {
		this.submitTime = submitTime;
	}

	public Long getSubmitDate() {
		return submitDate;
	}

	public void setSubmitDate(Long submitDate) {
		this.submitDate = submitDate;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}


}
