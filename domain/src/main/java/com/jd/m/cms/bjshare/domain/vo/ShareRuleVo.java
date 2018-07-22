package com.jd.m.cms.bjshare.domain.vo;

import com.jd.m.cms.bjshare.domain.po.ShareRule;

/**
 * @author huanglong
 * @Description: 分享规则
 * @date 2018/6/2511:40
 */
public class ShareRuleVo extends ShareRule {

    private String callerCode;

    private String key;

    private String businessCode;

    private Integer topBusinessId;

    private Integer secondBusinessId;

    private Integer orgId;

    public String getCallerCode() {
        return callerCode;
    }

    public void setCallerCode(String callerCode) {
        this.callerCode = callerCode;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(String businessCode) {
        this.businessCode = businessCode;
    }

    public Integer getTopBusinessId() {
        return topBusinessId;
    }

    public void setTopBusinessId(Integer topBusinessId) {
        this.topBusinessId = topBusinessId;
    }

    public Integer getSecondBusinessId() {
        return secondBusinessId;
    }

    public void setSecondBusinessId(Integer secondBusinessId) {
        this.secondBusinessId = secondBusinessId;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }
}
