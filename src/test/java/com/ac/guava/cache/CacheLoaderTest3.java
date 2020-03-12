package com.ac.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**CacheLoader guava
 * @author anchao
 * @date 2020/3/12 13:46
 */
public class CacheLoaderTest3 {


    //缓存过期时间设置 TTL time to live
    @Test
    public void testEvictionByAccessTime() throws InterruptedException {

        LoadingCache<String,Employee> cache = CacheBuilder.newBuilder()
                .expireAfterAccess(2, TimeUnit.SECONDS)
                .build(this.createCacheLoader());

        assertThat(cache.getUnchecked("alex"),notNullValue());
        assertThat(cache.size(),equalTo(1L));
        TimeUnit.SECONDS.sleep(3);
        System.out.println("----------->"+cache);
        assertThat(cache.getIfPresent("alex"),nullValue());
    }


    // write time 读不会产生影响
    @Test
    public void testEvictionByWriteTime() throws InterruptedException {

        LoadingCache<String,Employee> cache = CacheBuilder.newBuilder()
                .expireAfterWrite(2, TimeUnit.SECONDS)
                .build(this.createCacheLoader());

        assertThat(cache.getUnchecked("alex"),notNullValue());
        assertThat(cache.size(),equalTo(1L));
        TimeUnit.SECONDS.sleep(1);
        System.out.println("----------->"+cache);
        assertThat(cache.getIfPresent("alex"),notNullValue());
        TimeUnit.SECONDS.sleep(1);
        assertThat(cache.getIfPresent("alex"),nullValue());

    }

    /**
     * Strong/soft/weak/Phantom reference
     */
    @Test
    public void testWeakKey() throws InterruptedException {
        LoadingCache<String,Employee> cache = CacheBuilder.newBuilder()
                .expireAfterWrite(2, TimeUnit.SECONDS)
                .weakKeys()
                .weakValues()
                .build(this.createCacheLoader());

        assertThat(cache.getUnchecked("alex"),notNullValue());
        assertThat(cache.getUnchecked("guava"),notNullValue());

        System.gc();//弱引用gc回收

        TimeUnit.MILLISECONDS.sleep(1);
        assertThat(cache.getIfPresent("alex"),nullValue());


    }

    //soft (jvm接近满时 回收 soft引用)
    @Test
    public void testSoft() throws InterruptedException {
        LoadingCache<String,Employee> cache = CacheBuilder.newBuilder()
                .expireAfterWrite(2, TimeUnit.SECONDS)
                .softValues()
                .build(this.createCacheLoader());
        int i =0;
        for (;;){
            cache.put("Alex "+i,new Employee("Alex "+1,"Alex "+1,"Alex "+1));
            System.out.println("The employee "+(i++)+" int to cache .");
            TimeUnit.MILLISECONDS.sleep(600);
        }




    }


    //获取 cacheLoader
    private CacheLoader<String,Employee> createCacheLoader(){
        CacheLoader<String, Employee> cacheLoader = CacheLoader
                .from(key -> new Employee(key, key, key));//这里可以调用DB
        return cacheLoader;
    }


}
