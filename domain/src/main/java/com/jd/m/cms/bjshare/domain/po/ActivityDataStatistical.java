package com.jd.m.cms.bjshare.domain.po;

import java.io.Serializable;
import java.util.Date;

public class ActivityDataStatistical implements Serializable {

	private static final long serialVersionUID = 6480879915251521821L;
	//主键
	private Integer id;
	//创建人
    private String creator;
	//创建时间
    private Date createDate;
	//修改人
    private String modifier;
	//修改时间
    private Date modifyTime;
	//是否逻辑删除（默认0）
    private Integer isDelete;
	//spu或者店铺id
    private String bizid;
	//类型：1、商详；2、店铺；3、通天塔
    private Integer bizType;
	//页面uv
    private Long pageUv;
	//活动id
    private Long activityId;
	//商家id
    private Long venderId;
	//统计日期
    private Date statisticalTime;
	//统计日期long型
    private Long statisticalDate;
	//活动名称
    private String activityName;
	//分享点击次数
    private Long clickNumber;
	//分享成功的uv
    private Long clickSuccessUv;
	//打开次数
    private Long openNumber;
	//打开uv
    private Long openSuccessUv;
	//引入订单数量
    private Long orderNumber;
	//引入订单金额
    private Long orderAmount;
	//平均引流数量
    private Long drainageAvgNum;
	//引入dau
    private Long importDau;
	//用户使用优惠券数量
    private Long couponUsedAmount;
	//用户京豆使用数量
    private Long beanUsedAmount;
	//商家发放优惠券数量
    private Long couponCostAmount;
	//商家发放京豆数量
    private Long beanCostAmount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getBizid() {
        return bizid;
    }

    public void setBizid(String bizid) {
        this.bizid = bizid == null ? null : bizid.trim();
    }

    public Integer getBizType() {
        return bizType;
    }

    public void setBizType(Integer bizType) {
        this.bizType = bizType;
    }

    public Long getPageUv() {
        return pageUv;
    }

    public void setPageUv(Long pageUv) {
        this.pageUv = pageUv;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Long getVenderId() {
        return venderId;
    }

    public void setVenderId(Long venderId) {
        this.venderId = venderId;
    }

    public Date getStatisticalTime() {
        return statisticalTime;
    }

    public void setStatisticalTime(Date statisticalTime) {
        this.statisticalTime = statisticalTime;
    }

    public Long getStatisticalDate() {
        return statisticalDate;
    }

    public void setStatisticalDate(Long statisticalDate) {
        this.statisticalDate = statisticalDate;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName == null ? null : activityName.trim();
    }

    public Long getClickNumber() {
        return clickNumber;
    }

    public void setClickNumber(Long clickNumber) {
        this.clickNumber = clickNumber;
    }

    public Long getClickSuccessUv() {
        return clickSuccessUv;
    }

    public void setClickSuccessUv(Long clickSuccessUv) {
        this.clickSuccessUv = clickSuccessUv;
    }

    public Long getOpenNumber() {
        return openNumber;
    }

    public void setOpenNumber(Long openNumber) {
        this.openNumber = openNumber;
    }

    public Long getOpenSuccessUv() {
        return openSuccessUv;
    }

    public void setOpenSuccessUv(Long openSuccessUv) {
        this.openSuccessUv = openSuccessUv;
    }

    public Long getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Long getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Long orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Long getDrainageAvgNum() {
        return drainageAvgNum;
    }

    public void setDrainageAvgNum(Long drainageAvgNum) {
        this.drainageAvgNum = drainageAvgNum;
    }

    public Long getImportDau() {
        return importDau;
    }

    public void setImportDau(Long importDau) {
        this.importDau = importDau;
    }

    public Long getCouponUsedAmount() {
        return couponUsedAmount;
    }

    public void setCouponUsedAmount(Long couponUsedAmount) {
        this.couponUsedAmount = couponUsedAmount;
    }

    public Long getBeanUsedAmount() {
        return beanUsedAmount;
    }

    public void setBeanUsedAmount(Long beanUsedAmount) {
        this.beanUsedAmount = beanUsedAmount;
    }

    public Long getCouponCostAmount() {
        return couponCostAmount;
    }

    public void setCouponCostAmount(Long couponCostAmount) {
        this.couponCostAmount = couponCostAmount;
    }

    public Long getBeanCostAmount() {
        return beanCostAmount;
    }

    public void setBeanCostAmount(Long beanCostAmount) {
        this.beanCostAmount = beanCostAmount;
    }

}