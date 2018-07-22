package com.jd.m.cms.bjshare.domain.bean;

import com.alibaba.dubbo.common.utils.ConcurrentHashSet;

import java.util.Set;

/**
 * @author huanglong
 * @Description: sku验证结果
 * @date 2018/7/921:20
 */
public class SkuValidateResult {

    private Set<Long> validatSkus = new ConcurrentHashSet<Long>();
    private Set<Long> skusInActivity = new ConcurrentHashSet<Long>();
    private Set<Long> skusNotSelf = new ConcurrentHashSet<Long>();
    private Set<Long> skusTpyeError = new ConcurrentHashSet<Long>();


    public Set<Long> getValidatSkus() {
        return validatSkus;
    }

    public void setValidatSkus(Set<Long> validatSkus) {
        this.validatSkus = validatSkus;
    }

    public Set<Long> getSkusInActivity() {
        return skusInActivity;
    }

    public void setSkusInActivity(Set<Long> skusInActivity) {
        this.skusInActivity = skusInActivity;
    }

    public Set<Long> getSkusNotSelf() {
        return skusNotSelf;
    }

    public void setSkusNotSelf(Set<Long> skusNotSelf) {
        this.skusNotSelf = skusNotSelf;
    }

    public Set<Long> getSkusTpyeError() {
        return skusTpyeError;
    }

    public void setSkusTpyeError(Set<Long> skusTpyeError) {
        this.skusTpyeError = skusTpyeError;
    }
}
