package com.jd.m.cms.bjshare.domain.vo;

import java.io.Serializable;

/**
 * Created by LPC on 2018/9/21
 */
public class UvData implements Serializable {
    //活动id
    private Long activityId;
    //Uv数
    private long uvNum;
    //分享者的UV
    private Long shareUvNnm;
    //被分享者的UV
    private Long sharedUvNnm;

    public Long getShareUvNnm() {
        return shareUvNnm;
    }

    public void setShareUvNnm(Long shareUvNnm) {
        this.shareUvNnm = shareUvNnm;
    }

    public Long getSharedUvNnm() {
        return sharedUvNnm;
    }

    public void setSharedUvNnm(Long sharedUvNnm) {
        this.sharedUvNnm = sharedUvNnm;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public long getUvNum() {
        return uvNum;
    }

    public void setUvNum(long uvNum) {
        this.uvNum = uvNum;
    }
}
