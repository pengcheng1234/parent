package com.jd.m.statistics.domain.enums;

import com.jd.common.util.StringUtils;

/**
 * @author huanglong
 * @Description: redis键的定义
 * @date 2018/4/915:38
 */
public enum RedisKeyEnum {

    /**
     * 每个pin奖励的限制
     */
    SHARE_PIN_REMAIN("share_pin_remain"),

    /**
     * 需要下线的活动
     */
    //SHARE_ACTIVITY_OFFLINE("share_activity_offline"),
    /**
     * 京豆计划剩余的京豆
     * key 由京豆planid和activityid确定
     */
    SHARE_BEAN_REMAIN("share_bean_remain"),

    /***
     * 存放activity和bizId之间的关系之间的关系
     */
    SHARE_RELATION_ACTIVITYID_BIZID("share_relation_activityId_bizId"),
    /***
     * 活动分享成功
     * 存放token和bizId及pin等之间的关系
     */
    SHARE_SUCCESS_TOKEN("share_success_token"),

    /**
     * 用户中奖key,Spu|shopid+pin+rewardType 组成
     */
    SHARE_PRIZE("share_prize"),
    /**
     * 奖励信息的剩余情况，
     * activity_limit:activity_id:天:分享者类型
     */
    SHARE_ACTIVITY_LIMIT("share_activity_limit"),

    /**
     * 活动信息
     */
    SHARE_ACTIVITY("share_activity"),
    /**
     *存放分享标题
     */
    SHARE_CONTENT_SHOP_TITLES("share_content:shop:titles"),
    SHARE_CONTENT_SPU_TITLES("share_content:spu:titles"),
    /**
     *存放分享内容
     */
    SHARE_CONTENT_SHOP_CONTENTS("share_content:shop:contents"),
    SHARE_CONTENT_SPU_CONTENTS("share_content:spu:contents"),
    /**
     *  活动的过期时间(zset)
     */
    SHARE_ACTIVITY_EXPIRE("share_activity_expire"),

    /**
     *  活动的过期时间(zset),适配pop和自营后台
     */
    SHARE_ACTIVITY_EXPIRE_ALL("share_activity_expire_all"),

    /**
     * 活动的开始时间(zset)
     */
    SHARE_ACTIVITY_START("share_activity_start"),

    /**
     * 活动的开始时间(zset),适配pop和自营后台
     */
    SHARE_ACTIVITY_START_ALL("share_activity_start_all"),

    /**
     * 清除redis的数据
     */
    SHARE_ACTIVITY_CLEAN("share_activity_clean"),

    SHARE_CLIENT_UV("share_client_uv");


    /**
     * 前缀
     */
    private String prefix;

    RedisKeyEnum(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getPrefix(String mark) {
        return prefix + mark;
    }

    public  String getCacheKey(String...args){
        StringBuffer sb = new StringBuffer();
        sb.append(prefix);
        if(args.length!=0){
            for(String arg:args){
                if(StringUtils.isNotBlank(arg)){
                    sb.append(":").append(arg);
                }
            }
        }
        return sb.toString();
    }

}
