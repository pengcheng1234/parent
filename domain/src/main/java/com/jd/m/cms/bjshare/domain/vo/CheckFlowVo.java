package com.jd.m.cms.bjshare.domain.vo;

import java.util.List;

/**
 * @author huanglong
 * @Description: 审批流
 * @date 2018/7/914:08
 */
public class CheckFlowVo {

    private List<CheckFlowMessage> checkFlowMessages;

    private boolean ifCheck;

    public List<CheckFlowMessage> getCheckFlowMessages() {
        return checkFlowMessages;
    }

    public void setCheckFlowMessages(List<CheckFlowMessage> checkFlowMessages) {
        this.checkFlowMessages = checkFlowMessages;
    }

    public boolean isIfCheck() {
        return ifCheck;
    }

    public void setIfCheck(boolean ifCheck) {
        this.ifCheck = ifCheck;
    }
}
