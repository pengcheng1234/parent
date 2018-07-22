package com.jd.m.cms.bjshare.domain.vo;

/**
 * @description: 京豆校验的返回结果
 * @author: renzhuang
 * @create: 2018-07-07 14:11
 **/
public class JingBeanResponseVo {
    /***
     * 预计发放京东
     */
    private long expectedBeans;
    /***
     * 京豆池中剩余京豆
     */
    private long remainingBeans;
    public long getExpectedBeans() {
        return expectedBeans;
    }

    public void setExpectedBeans(long expectedBeans) {
        this.expectedBeans = expectedBeans;
    }

    public long getRemainingBeans() {
        return remainingBeans;
    }

    public void setRemainingBeans(long remainingBeans) {
        this.remainingBeans = remainingBeans;
    }
}
