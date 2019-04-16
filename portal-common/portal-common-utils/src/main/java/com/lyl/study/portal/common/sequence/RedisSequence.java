package com.lyl.study.portal.common.sequence;

import org.springframework.data.redis.core.RedisTemplate;

public class RedisSequence implements Sequence {
    private RedisTemplate redisTemplate;

    public RedisSequence(RedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public long nextId() {
        throw new UnsupportedOperationException("Redis的ID自增必须指定Key");
    }

    @SuppressWarnings("unchecked")
    @Override
    public long nextId(String key) {
        return redisTemplate.opsForValue().increment(key, 1);
    }
}
