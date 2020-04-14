package com.ac.redis.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.crazycake.shiro.RedisCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;

/**
 * @author anchao
 * @date 2020/3/6 0:27
 */
//@EnableCaching
@Configuration
public class RedisConfig {


    /**
     * redis替换spring cache
     * 暂时注掉
     * shiro用的cacheManager
     * @see RedisCacheManager
     */
//    @Bean
//    public CacheManager cacheManager(RedisTemplate redisTemplate) {
//        //redis连接
//        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(redisTemplate.getConnectionFactory());
//        //redis序列化方式
//        RedisSerializationContext.SerializationPair<Object> serializationPair = RedisSerializationContext.SerializationPair
//                .fromSerializer(getObjectJackson2JsonRedisSerializer());
//        //序列化和过期设置
//        RedisCacheConfiguration cacheConfiguration = RedisCacheConfiguration.defaultCacheConfig()
//                .serializeValuesWith(serializationPair);
//        Map<String, RedisCacheConfiguration> redisCacheConfigurationMap = new HashMap<>();
//        //指定cacheName前缀
//        redisCacheConfigurationMap.put(RedisCacheConstant.CACHE_NAME_PREFIX, cacheConfiguration);
//
//        return new RedisCacheManager(redisCacheWriter,cacheConfiguration);
//    }

    @Bean
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = getObjectJackson2JsonRedisSerializer();
        redisTemplate.setKeySerializer(jackson2JsonRedisSerializer);
        redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashKeySerializer(jackson2JsonRedisSerializer);
        redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
        redisTemplate.setDefaultSerializer(jackson2JsonRedisSerializer);
        return redisTemplate;
    }



    private Jackson2JsonRedisSerializer<Object> getObjectJackson2JsonRedisSerializer() {
        // 使用Jackson2JsonRedisSerialize 替换默认序列化(默认采用的是JDK序列化)
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        return jackson2JsonRedisSerializer;
    }
}
