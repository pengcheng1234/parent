package com.jd.m.cms.bjshare.domain.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author zhangxiangwei6
 * @create 2018-04-24 16:06
 **/
public class CouponDataVo implements Serializable {

	private static final long serialVersionUID = -4087383798299890798L;

	private Long activityId;

	private String orderId;

	private String spuId;

	private String skuId;

	private BigDecimal amount;

	private Date submitTime;

	private Long submitDate;

	private String pin;

	private Boolean usedCoupon;

	private String couponId;

	private Byte couponType;

	private String couponDes;

	private Byte couponSendType;

	private Date couponSendTime;

	private String usedCouponName;//是否使用


	private String couponTypeName;//券类型


	private String couponSendTypeName;//发放券

	public String getUsedCouponName() {
		return usedCouponName;
	}

	public void setUsedCouponName(String usedCouponName) {
		this.usedCouponName = usedCouponName;
	}

	public String getCouponTypeName() {
		return couponTypeName;
	}

	public void setCouponTypeName(String couponTypeName) {
		this.couponTypeName = couponTypeName;
	}

	public String getCouponSendTypeName() {
		return couponSendTypeName;
	}

	public void setCouponSendTypeName(String couponSendTypeName) {
		this.couponSendTypeName = couponSendTypeName;
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

	public String getSpuId() {
		return spuId;
	}

	public void setSpuId(String spuId) {
		this.spuId = spuId;
	}

	public String getSkuId() {
		return skuId;
	}

	public void setSkuId(String skuId) {
		this.skuId = skuId;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
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

	public Boolean getUsedCoupon() {
		return usedCoupon;
	}

	public void setUsedCoupon(Boolean usedCoupon) {
		this.usedCoupon = usedCoupon;
	}

	public String getCouponId() {
		return couponId;
	}

	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}

	public Byte getCouponType() {
		return couponType;
	}

	public void setCouponType(Byte couponType) {
		this.couponType = couponType;
	}

	public String getCouponDes() {
		return couponDes;
	}

	public void setCouponDes(String couponDes) {
		this.couponDes = couponDes;
	}

	public Byte getCouponSendType() {
		return couponSendType;
	}

	public void setCouponSendType(Byte couponSendType) {
		this.couponSendType = couponSendType;
	}

	public Date getCouponSendTime() {
		return couponSendTime;
	}

	public void setCouponSendTime(Date couponSendTime) {
		this.couponSendTime = couponSendTime;
	}
}
