package com.jd.m.statistics.domain;/**
 * Created by renzhuang on 2018/8/21.
 */

import com.jd.m.cms.bjshare.domain.po.ActivityDataStatistical;
import com.jd.m.cms.bjshare.domain.po.ActivityDataStatisticalAdditional;

/**
 * @description: 统计表和统计附加表的集合
 * @author: renzhuang
 * @create: 2018-08-21 11:48
 **/
public class Statistical {
    private ActivityDataStatistical activityDataStatistical = new ActivityDataStatistical();

    private ActivityDataStatisticalAdditional activityDataStatisticalAdditional = new ActivityDataStatisticalAdditional();

    public ActivityDataStatistical getActivityDataStatistical() {
        return activityDataStatistical;
    }

    public void setActivityDataStatistical(ActivityDataStatistical activityDataStatistical) {
        this.activityDataStatistical = activityDataStatistical;
    }

    public ActivityDataStatisticalAdditional getActivityDataStatisticalAdditional() {
        return activityDataStatisticalAdditional;
    }

    public void setActivityDataStatisticalAdditional(ActivityDataStatisticalAdditional activityDataStatisticalAdditional) {
        this.activityDataStatisticalAdditional = activityDataStatisticalAdditional;
    }
}
