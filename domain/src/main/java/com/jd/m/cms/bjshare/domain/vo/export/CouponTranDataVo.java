package com.jd.m.cms.bjshare.domain.vo.export;

import com.jd.m.cms.bjshare.common.utils.DateUtil;
import com.jd.m.cms.bjshare.domain.vo.CouponDataVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxiangwei6
 * @create 2018-04-24 16:06
 **/
public class CouponTranDataVo {


	private Long activityId;

	private String orderId;

	private String spuId;

	private String skuId;

	private String amount;

	private String submitTime;

	private Long submitDate;

	private String pin;

	private String usedCoupon;

	private String couponId;

	private String couponType;

	private String couponDes;

	private String couponSendType;

	private String couponSendTime;

	public static List<CouponTranDataVo> tranEntity(List<CouponDataVo> couponDataVos) {

		if(couponDataVos == null || couponDataVos.size() == 0) {
			return new ArrayList<CouponTranDataVo>(0);
		}

		List<CouponTranDataVo> couponTranDataVos = new ArrayList<CouponTranDataVo>();
		for(int i=0; i<couponDataVos.size();i++) {
			CouponDataVo couponDataVo = couponDataVos.get(i);
			CouponTranDataVo vo = new CouponTranDataVo();
			vo.setSkuId(couponDataVo.getSkuId());
			vo.setOrderId(couponDataVo.getOrderId());
			if(couponDataVo.getCouponSendType() == 0) {
				vo.setCouponSendType("批次");
			}
            vo.setCouponId(couponDataVo.getCouponId());
			if(couponDataVo.getCouponType() == 0) {
				vo.setCouponType("拉新");
			} else if(couponDataVo.getCouponType() == 1){
				vo.setCouponType("满减");
			}
			vo.setPin(couponDataVo.getPin());
			if(couponDataVo.getUsedCoupon()) {
				vo.setUsedCoupon("是");
			} else{
				vo.setUsedCoupon("否");
			}
			vo.setSubmitTime(DateUtil.formatDateToString(couponDataVo.getSubmitTime(),DateUtil.YYMMDDHHMMSS));
			vo.setAmount(couponDataVo.getAmount() != null ?couponDataVo.getAmount() .toString() : "");
			vo.setCouponSendTime(DateUtil.formatDateToString(couponDataVo.getCouponSendTime(),DateUtil.YYMMDDHHMMSS));
			couponTranDataVos.add(vo);
		}
		return couponTranDataVos;
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

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(String submitTime) {
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

	public String getUsedCoupon() {
		return usedCoupon;
	}

	public void setUsedCoupon(String usedCoupon) {
		this.usedCoupon = usedCoupon;
	}

	public String getCouponId() {
		return couponId;
	}

	public void setCouponId(String couponId) {
		this.couponId = couponId;
	}

	public String getCouponType() {
		return couponType;
	}

	public void setCouponType(String couponType) {
		this.couponType = couponType;
	}

	public String getCouponDes() {
		return couponDes;
	}

	public void setCouponDes(String couponDes) {
		this.couponDes = couponDes;
	}

	public String getCouponSendType() {
		return couponSendType;
	}

	public void setCouponSendType(String couponSendType) {
		this.couponSendType = couponSendType;
	}

	public String getCouponSendTime() {
		return couponSendTime;
	}

	public void setCouponSendTime(String couponSendTime) {
		this.couponSendTime = couponSendTime;
	}
}
