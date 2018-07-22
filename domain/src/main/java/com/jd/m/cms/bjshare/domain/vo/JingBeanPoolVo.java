package com.jd.m.cms.bjshare.domain.vo;

/**
 * @description: 页面传来的京豆参数
 * @author: renzhuang
 * @create: 2018-07-05 17:43
 **/
public class JingBeanPoolVo {

    /**
     * 每日赠送份数
     */
    private Long perDayGiftNumber;
    /***
     *每次发豆量
     */
    private Long eachBeansNumber;
    /***
     *总赠送份数
     */
    private Long totalGiftNumber;
    /**
     * 调用端编号
     */
    private String callerId;
    /**
     * 业务方编号
     */
    private String businessId;
    /**
     * 一级业务编号
     */
    private String topBusinessId;
    /**
     * 二级业务编号
     */
    private String secondBusinessId;
    /**
     * 京豆配置密钥
     */
    private String key;



    public Long getPerDayGiftNumber() {
        return perDayGiftNumber;
    }

    public void setPerDayGiftNumber(Long perDayGiftNumber) {
        this.perDayGiftNumber = perDayGiftNumber;
    }

    public Long getEachBeansNumber() {
        return eachBeansNumber;
    }

    public void setEachBeansNumber(Long eachBeansNumber) {
        this.eachBeansNumber = eachBeansNumber;
    }

    public Long getTotalGiftNumber() {
        return totalGiftNumber;
    }

    public void setTotalGiftNumber(Long totalGiftNumber) {
        this.totalGiftNumber = totalGiftNumber;
    }

    public String getCallerId() {
        return callerId;
    }

    public void setCallerId(String callerId) {
        this.callerId = callerId;
    }

    public String getBusinessId() {
        return businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId;
    }

    public String getTopBusinessId() {
        return topBusinessId;
    }

    public void setTopBusinessId(String topBusinessId) {
        this.topBusinessId = topBusinessId;
    }

    public String getSecondBusinessId() {
        return secondBusinessId;
    }

    public void setSecondBusinessId(String secondBusinessId) {
        this.secondBusinessId = secondBusinessId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
