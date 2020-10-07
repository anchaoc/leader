package com.ac.redis.junit;

import com.ac.leader.junit.BaseTest;
import com.ac.redis.service.base.RedisService;
import com.google.common.collect.Maps;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @author anchao
 * @date 2020/3/6 0:35
 */
public class RedisServiceTest extends BaseTest {

    @Resource
    RedisService redisService;

    @Test
    public void putHash(){
        HashMap<String, Object> hashMap = Maps.newHashMap();
        hashMap.put("key",200);
        redisService.putHash("NAMESPACE",hashMap,null);
        System.out.println("ok");
    }

    @Test
    public void incr(){
        System.out.println(redisService.incr("incr", 1L));
    }



}
