package com.jd.m.cms.bjshare.domain.po;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ShareActivityOrderStatistics implements Serializable {

	private static final long serialVersionUID = 423071324474453817L;

	private Long id;

    private String creator;

    private Date createTime;

    private Long createDate;

    private String modifier;

    private Date modifyTime;

    private Long modifyDate;

    private Boolean isDelete;

    private Long activityId;

    private String orderId;

    private String spuId;

    private String skuId;

    private BigDecimal amount;

    private Date submitTime;

    private Long submitDate;

    private String pin;

    private Integer usedCoupon;

    private String couponId;

    private Integer couponType;

    private String couponDes;

    private Integer couponSendType;

    private Date couponSendTime;

    private Long shopId;

    private String token;

    private Long venderId;

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

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
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
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getSpuId() {
        return spuId;
    }

    public void setSpuId(String spuId) {
        this.spuId = spuId == null ? null : spuId.trim();
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId == null ? null : skuId.trim();
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
        this.pin = pin == null ? null : pin.trim();
    }

    public Integer getUsedCoupon() {
        return usedCoupon;
    }

    public void setUsedCoupon(Integer usedCoupon) {
        this.usedCoupon = usedCoupon;
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId == null ? null : couponId.trim();
    }

    public Integer getCouponType() {
        return couponType;
    }

    public void setCouponType(Integer couponType) {
        this.couponType = couponType;
    }

    public String getCouponDes() {
        return couponDes;
    }

    public void setCouponDes(String couponDes) {
        this.couponDes = couponDes == null ? null : couponDes.trim();
    }

    public Integer getCouponSendType() {
        return couponSendType;
    }

    public void setCouponSendType(Integer couponSendType) {
        this.couponSendType = couponSendType;
    }

    public Date getCouponSendTime() {
        return couponSendTime;
    }

    public void setCouponSendTime(Date couponSendTime) {
        this.couponSendTime = couponSendTime;
    }

	public Boolean getDelete() {
		return isDelete;
	}

	public void setDelete(Boolean delete) {
		isDelete = delete;
	}

	public Long getShopId() {
		return shopId;
	}

	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getVenderId() {
		return venderId;
	}

	public void setVenderId(Long venderId) {
		this.venderId = venderId;
	}
}