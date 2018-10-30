package com.redis;

import redis.clients.jedis.Jedis;

/**
 * Created by LPC on 2018/8/22
 */
public interface JedisClient {
    String set(String key, String value);
    String get(String key);
    Boolean exists(String key);
    Long expire(String key, int seconds);
    Long ttl(String key);
    Long incr(String key);
    Long hset(String key, String field, String value);
    String hget(String key, String field);
    Long hdel(String key, String... field);
    /**
     * 尝试获取分布式锁
     * @param lockKey 锁
     * @param requestId 请求标识
     * @param expireTime 超期时间
     * @return 是否获取成功
     */
    boolean tryGetDistributedLock( String lockKey, String requestId, int expireTime);

    /**
     * 释放分布式锁
     * @param lockKey 锁
     * @param requestId 请求标识
     * @return 是否释放成功
     */
    boolean releaseDistributedLock( String lockKey, String requestId);

}
