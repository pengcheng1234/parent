package com.jd.m.cms.bjshare.domain.po;

public class ShareActivityAdditionalWithBLOBs extends ShareActivityAdditional {
    private String invalidSku;

    private String effectiveSku;

    private String sku;

    public String getInvalidSku() {
        return invalidSku;
    }

    public void setInvalidSku(String invalidSku) {
        this.invalidSku = invalidSku == null ? null : invalidSku.trim();
    }

    public String getEffectiveSku() {
        return effectiveSku;
    }

    public void setEffectiveSku(String effectiveSku) {
        this.effectiveSku = effectiveSku == null ? null : effectiveSku.trim();
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku == null ? null : sku.trim();
    }
}