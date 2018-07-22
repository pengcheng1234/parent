package com.jd.m.cms.bjshare.domain.vo;

import java.io.Serializable;

/**
 * @author zhangxiangwei6
 * @create 2018-05-07 21:21
 * 数据看板汇总数据
 **/
public class ActivityDataCountVo implements Serializable {

	private static final long serialVersionUID = 7065829608725357516L;

	//页面uv
	private Long pageUvCount;
	//分享点击次数
	private Long clickNumberCount;
	//分享成功的uv
	private Long clickSuccessUvCount;
	//打开次数
	private Long openNumberCount;
	//打开uv
	private Long openSuccessUvCount;
	//引入订单数量
	private Long orderNumberCount;
	//引入订单金额
	private Long orderAmountCount;
	//用户使用优惠券数量
	private Long couponUsedAmountCount;
	//用户京豆使用数量
	private Long beanUsedAmountCount;
	//商家发放优惠券数量
	private Long couponCostAmountCount;
	//商家发放京豆数量
	private Long beanCostAmountCount;

	public Long getPageUvCount() {
		return pageUvCount;
	}

	public void setPageUvCount(Long pageUvCount) {
		this.pageUvCount = pageUvCount;
	}

	public Long getClickNumberCount() {
		return clickNumberCount;
	}

	public void setClickNumberCount(Long clickNumberCount) {
		this.clickNumberCount = clickNumberCount;
	}

	public Long getClickSuccessUvCount() {
		return clickSuccessUvCount;
	}

	public void setClickSuccessUvCount(Long clickSuccessUvCount) {
		this.clickSuccessUvCount = clickSuccessUvCount;
	}

	public Long getOpenNumberCount() {
		return openNumberCount;
	}

	public void setOpenNumberCount(Long openNumberCount) {
		this.openNumberCount = openNumberCount;
	}

	public Long getOpenSuccessUvCount() {
		return openSuccessUvCount;
	}

	public void setOpenSuccessUvCount(Long openSuccessUvCount) {
		this.openSuccessUvCount = openSuccessUvCount;
	}

	public Long getOrderNumberCount() {
		return orderNumberCount;
	}

	public void setOrderNumberCount(Long orderNumberCount) {
		this.orderNumberCount = orderNumberCount;
	}

	public Long getOrderAmountCount() {
		return orderAmountCount;
	}

	public void setOrderAmountCount(Long orderAmountCount) {
		this.orderAmountCount = orderAmountCount;
	}

	public Long getCouponUsedAmountCount() {
		return couponUsedAmountCount;
	}

	public void setCouponUsedAmountCount(Long couponUsedAmountCount) {
		this.couponUsedAmountCount = couponUsedAmountCount;
	}

	public Long getBeanUsedAmountCount() {
		return beanUsedAmountCount;
	}

	public void setBeanUsedAmountCount(Long beanUsedAmountCount) {
		this.beanUsedAmountCount = beanUsedAmountCount;
	}

	public Long getCouponCostAmountCount() {
		return couponCostAmountCount;
	}

	public void setCouponCostAmountCount(Long couponCostAmountCount) {
		this.couponCostAmountCount = couponCostAmountCount;
	}

	public Long getBeanCostAmountCount() {
		return beanCostAmountCount;
	}

	public void setBeanCostAmountCount(Long beanCostAmountCount) {
		this.beanCostAmountCount = beanCostAmountCount;
	}
}
