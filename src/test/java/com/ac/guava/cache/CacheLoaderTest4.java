package com.ac.guava.cache;

import com.google.common.base.Optional;
import com.google.common.cache.*;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

/**
 *
 * @author anchao
 * @date 2020/3/12 15:31
 */
public class CacheLoaderTest4 {


    //空值处理
    @Test
    public void testLoadNullValue() {
        CacheLoader<String, Employee> cacheLoader = CacheLoader
                .from(k -> k.equals("null") ? null : new Employee(k, k, k));
        LoadingCache<String, Employee> loadingCache = CacheBuilder.newBuilder().build(cacheLoader);
        Employee alex = loadingCache.getUnchecked("Alex");
        System.out.println(alex.getName());
    }
    //空值处理
    @Test
    public void testLoaderNUllValueUseOptional() {
        CacheLoader<String, Optional<Employee>> cacheLoader = new CacheLoader<String, Optional<Employee>>() {
            @Override
            public Optional<Employee> load(String key) throws Exception {

                if (key.equals("null"))
                    return Optional.fromNullable(null);
                else
                    return Optional.of(new Employee(key, key, key));
            }
        };
        LoadingCache<String, Optional<Employee>> cache = CacheBuilder.newBuilder().build(cacheLoader);
        Optional<Employee> alex = cache.getUnchecked("Alex");
        assertThat(alex.get(),notNullValue());
        Employee or = cache.getUnchecked("null").or(new Employee("default", "default", "default"));
        System.out.println(or.getName());
    }

    //刷新缓存
    @Test
    public void testCacheRefresh() throws InterruptedException {
        CacheLoader<Object, Long> cacheLoader = CacheLoader.from(k -> System.currentTimeMillis());
        LoadingCache<Object, Long> cache = CacheBuilder.newBuilder()
                //2s 后刷新
                .refreshAfterWrite(2, TimeUnit.SECONDS).build(cacheLoader);
        Long result1 = cache.getUnchecked("An chao");
        TimeUnit.SECONDS.sleep(2);
        Long result2 = cache.getUnchecked("An chao");
        assertThat(result1.longValue()!=result2.longValue(),equalTo(true));
    }


    //获取被逐出的数据
    @Test
    public void testCacheRemovedNotification(){
        CacheLoader<String, String> cacheLoader = CacheLoader.<String, String>from(String::toUpperCase);
        RemovalListener<String,String> listener = notification -> {
            if(notification.wasEvicted()){
                String name = notification.getKey();
                System.out.println("name :" +name);
            }
        };
        LoadingCache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(3)
                .removalListener(listener)
                .build(cacheLoader);

        String alex = cache.getUnchecked("alex");
        String jack = cache.getUnchecked("jack");
        String wenjun = cache.getUnchecked("wenjun");
        String junge = cache.getUnchecked("junge");


    }

}