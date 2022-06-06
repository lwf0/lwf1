package com.lwf.demo.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RedisUtil {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    public  boolean set(String key, Object object){
        ValueOperations<String,Object> vo=redisTemplate.opsForValue();
        vo.set(key,object);
        return true;
    }

    public  Object get(String key){
        ValueOperations<String,Object> vo=redisTemplate.opsForValue();

        return vo.get(key);
    }
}
