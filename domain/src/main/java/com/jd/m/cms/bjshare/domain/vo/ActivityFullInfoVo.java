package com.jd.m.cms.bjshare.domain.vo;

import com.jd.m.cms.bjshare.domain.po.ShareActivity;

import java.util.List;

/**
 * @author huanglong
 * @Description: 活动的详细信息
 * @date 2018/7/611:34
 */
public class ActivityFullInfoVo extends ShareActivity {

    private String produceClassify;

    private String produceClassifyCn;

    private Byte activityType;

    private String shopName;

    private String invalidSku;

    private String effectiveSku;

    private String sku;

    private List<ShareRuleVo> shareRuleList;
    /**
     * 分享标题
     */
    private String titles;
    /**
     * 分享描述语
     */
    private String contents;

    /* 审批信息 */
    private CheckFlowVo checkFlowVo;


    public String getProduceClassify() {
        return produceClassify;
    }

    public void setProduceClassify(String produceClassify) {
        this.produceClassify = produceClassify;
    }

    public String getProduceClassifyCn() {
        return produceClassifyCn;
    }

    public void setProduceClassifyCn(String produceClassifyCn) {
        this.produceClassifyCn = produceClassifyCn;
    }

    public Byte getActivityType() {
        return activityType;
    }

    public void setActivityType(Byte activityType) {
        this.activityType = activityType;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public List<ShareRuleVo> getShareRuleList() {
        return shareRuleList;
    }

    public void setShareRuleList(List<ShareRuleVo> shareRuleList) {
        this.shareRuleList = shareRuleList;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public CheckFlowVo getCheckFlowVo() {
        return checkFlowVo;
    }

    public void setCheckFlowVo(CheckFlowVo checkFlowVo) {
        this.checkFlowVo = checkFlowVo;
    }

    public String getInvalidSku() {
        return invalidSku;
    }

    public void setInvalidSku(String invalidSku) {
        this.invalidSku = invalidSku;
    }

    public String getEffectiveSku() {
        return effectiveSku;
    }

    public void setEffectiveSku(String effectiveSku) {
        this.effectiveSku = effectiveSku;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
}
