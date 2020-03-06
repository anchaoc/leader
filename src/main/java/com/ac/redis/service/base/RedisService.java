package com.ac.redis.service.base;

import java.util.Map;

/**
 * @author anchao
 * @date 2020/3/6 0:18
 */
public interface RedisService<T> {


    /**
     * 存入hash
     */
     void putHash(String nameSpace, Map<String,T> map, Long time);


    /**
     * 获取redis自增
     */
     Long incr(String key,Long sum);

}
