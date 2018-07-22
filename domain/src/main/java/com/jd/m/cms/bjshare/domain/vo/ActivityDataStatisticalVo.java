package com.jd.m.cms.bjshare.domain.vo;

import com.jd.m.cms.bjshare.domain.po.ActivityDataStatistical;

/**
 * @author huanglong
 * @Description: 按活动统计Vo
 * @date 2018/5/2418:02
 */
public class ActivityDataStatisticalVo extends ActivityDataStatistical {

    private Long shopId;

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
}
