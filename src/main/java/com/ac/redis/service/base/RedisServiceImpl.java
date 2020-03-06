package com.ac.redis.service.base;

import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @author anchao
 * @date 2020/3/6 0:19
 */
@Component
public class RedisServiceImpl<T> implements RedisService<T> {

    @Resource
    private RedisTemplate redisTemplate;


    @Override
    public void putHash(String nameSpace, Map<String,T> map,Long time){
        BoundHashOperations boundHashOperations = redisTemplate.boundHashOps(nameSpace);
        boundHashOperations.putAll(map);
        if(null !=time){
            boundHashOperations.expire(time, TimeUnit.SECONDS);
        }
    }

    @Override
    public Long incr(String key, Long sum) {
        return redisTemplate.opsForValue().increment(key,sum);
    }

}
