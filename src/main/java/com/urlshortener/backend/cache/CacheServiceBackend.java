package com.urlshortener.backend.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.time.*;

@Service
public class CacheServiceBackend {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void save(String key, String value) {

        redisTemplate.opsForValue().set(key, value);
        redisTemplate.expire(key, Duration.ofMinutes(1));
    }
}