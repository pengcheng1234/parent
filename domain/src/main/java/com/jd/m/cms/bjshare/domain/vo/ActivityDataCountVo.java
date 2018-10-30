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
	//分享成功的总次数
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

	private Long clickNumberUvCount;//<!-- 分享有礼点击UV-->

	private Long shareSuccessUvCount;//<!-- 分享成功UV-->

	private Long actualOrderNumberCount;//<!--有效订单数量 -->

	private Long actualOrderAmountCount;//<!-- 有效订单金额-->

	private Long couponOrdernumberCount;//<!--券引入订单 -->

	private Long couponOrderAmountCount;//<!--券引入订单金额-->

	private Long activityNumCount;//活动总数

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

	public Long getClickNumberUvCount() {
		return clickNumberUvCount;
	}

	public void setClickNumberUvCount(Long clickNumberUvCount) {
		this.clickNumberUvCount = clickNumberUvCount;
	}

	public Long getShareSuccessUvCount() {
		return shareSuccessUvCount;
	}

	public void setShareSuccessUvCount(Long shareSuccessUvCount) {
		this.shareSuccessUvCount = shareSuccessUvCount;
	}

	public Long getActualOrderNumberCount() {
		return actualOrderNumberCount;
	}

	public void setActualOrderNumberCount(Long actualOrderNumberCount) {
		this.actualOrderNumberCount = actualOrderNumberCount;
	}

	public Long getActualOrderAmountCount() {
		return actualOrderAmountCount;
	}

	public void setActualOrderAmountCount(Long actualOrderAmountCount) {
		this.actualOrderAmountCount = actualOrderAmountCount;
	}

	public Long getCouponOrdernumberCount() {
		return couponOrdernumberCount;
	}

	public void setCouponOrdernumberCount(Long couponOrdernumberCount) {
		this.couponOrdernumberCount = couponOrdernumberCount;
	}

	public Long getCouponOrderAmountCount() {
		return couponOrderAmountCount;
	}

	public void setCouponOrderAmountCount(Long couponOrderAmountCount) {
		this.couponOrderAmountCount = couponOrderAmountCount;
	}

	public Long getActivityNumCount() {
		return activityNumCount;
	}

	public void setActivityNumCount(Long activityNumCount) {
		this.activityNumCount = activityNumCount;
	}
}
