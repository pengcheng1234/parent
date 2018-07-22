package com.jd.bjshare.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author huanglong
 * @Description: 分发奖励的规则
 * @date 2018/4/1023:34
 */
public class ActivityRewardRule implements Serializable {

    private static final long serialVersionUID = -5558554109814382735L;
    /* 活动限制分享者总奖励次数,0为不限制 */
    private Long rewardLimit;
    /* 活动每天限制分享者奖励次数,0为不限制 */
    private Long rewardLimitDay;

    private List<RewardInf> rewardInfs;

    public Long getRewardLimit() {
        return rewardLimit;
    }

    public void setRewardLimit(Long rewardLimit) {
        this.rewardLimit = rewardLimit;
    }

    public Long getRewardLimitDay() {
        return rewardLimitDay;
    }

    public void setRewardLimitDay(Long rewardLimitDay) {
        this.rewardLimitDay = rewardLimitDay;
    }

    public List<RewardInf> getRewardInfs() {
        return rewardInfs;
    }

    public void setRewardInfs(List<RewardInf> rewardInfs) {
        this.rewardInfs = rewardInfs;
    }
}
