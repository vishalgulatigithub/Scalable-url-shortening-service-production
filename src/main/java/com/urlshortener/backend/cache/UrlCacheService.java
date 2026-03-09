package com.urlshortener.backend.cache;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UrlCacheService {

    private final RedisTemplate<String, String> redisTemplate;

    public UrlCacheService(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void cacheUrl(String shortCode, String url) {
        redisTemplate.opsForValue().set(shortCode, url);
    }

    public String getCachedUrl(String shortCode) {
        return redisTemplate.opsForValue().get(shortCode);
    }
}