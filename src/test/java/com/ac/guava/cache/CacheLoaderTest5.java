package com.ac.guava.cache;

import com.google.common.cache.*;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author anchao
 * @date 2020/3/12 16:11
 */
public class CacheLoaderTest5 {


    //统计 缓存的状态 (鉴别缓存使用率)
    @Test
    public void cacheStat(){

        CacheLoader<String, String> cacheLoader = CacheLoader.from(String::toUpperCase);
        LoadingCache<String, String> loadingCache = CacheBuilder.newBuilder()
                //统计
                .recordStats()
                .build(cacheLoader);

        System.out.println(loadingCache.getUnchecked("alex"));
        assertThat(loadingCache.getUnchecked("alex"),equalTo("ALEX"));

       loadingCache.getUnchecked("alex");

        CacheStats stats = loadingCache.stats();

        //命中率 miss率 ...
        //CacheStats{hitCount=2, missCount=1, loadSuccessCount=1, loadExceptionCount=0, totalLoadTime=2137600, evictionCount=0
        System.out.println(" statistics : "+stats);

    }

    //自定义配置 缓存
    @Test
    public void testCacheSpec(){
        String sepc = "maximumSize=10,recordStats";
        CacheBuilderSpec parse = CacheBuilderSpec.parse(sepc);
        CacheLoader<String, String> cacheLoader = CacheLoader.<String, String>from(String::toUpperCase);
        LoadingCache<String, String> cache = CacheBuilder.from(parse).build(cacheLoader);
        cache.getUnchecked("alex");
        System.out.println( cache.getUnchecked("alex"));


    }
}
