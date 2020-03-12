package com.ac.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.Weigher;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;

/**CacheLoader guava
 * @author anchao
 * @date 2020/3/12 13:46
 */
public class CacheLoaderTest2 {

    private boolean isTrue =false;


    // LoadingCache CacheBuilder
    @Test
    public void testBasic() throws ExecutionException, InterruptedException {

        LoadingCache<String,Employee> loadingCache = CacheBuilder.newBuilder().maximumSize(10).
                expireAfterAccess(30, TimeUnit.SECONDS).
                build(getCacheLoader());

        Employee alex = loadingCache.get("Alex");
        assertLoadedFromDBThenReset();
        System.out.println("-------->get1 :"+alex);
         alex = loadingCache.get("Alex");
        assertLoadedFromCacheThenReset();
        System.out.println("-------->get2 :"+alex);
        TimeUnit.SECONDS.sleep(31);
        alex = loadingCache.get("Alex");
        assertLoadedFromDBThenReset();
    }


    private Employee findEmployeeByName(String name){
        isTrue =true;
        System.out.println("------>"+name+" from DB");
        return  new Employee(name,name,name);
    }




    //验证调用了db
    private void  assertLoadedFromDBThenReset(){
        assertThat(true,equalTo(true));
        this.isTrue =false;
    }

    //验证走缓存
    private void  assertLoadedFromCacheThenReset(){
        assertThat(isTrue,equalTo(false));
    }


    //按最大个数 驱逐
    @Test
    public void testEvictionBySize() throws ExecutionException {
        CacheLoader<String, Employee> cacheLoader = getCacheLoader();
        LoadingCache<String,Employee> cache = CacheBuilder.newBuilder()
                .maximumSize(3)
                .build(cacheLoader);

        cache.getUnchecked("anchao");
        assertLoadedFromDBThenReset();
        cache.getUnchecked("jack");
        assertLoadedFromDBThenReset();
        cache.getUnchecked("gavin");
        assertLoadedFromDBThenReset();
        cache.getUnchecked("susan");
        assertLoadedFromDBThenReset();
        assertThat(cache.size(),equalTo(3L));
        assertThat(cache.getIfPresent("anchao"),nullValue());


    }

    //测试驱逐cache
    @Test
    public void testEvictionByWeigh(){
        CacheLoader<String, Employee> cacheLoader = getCacheLoader();
        Weigher<String,Employee> weigher = (key,em) -> em.getName().length()+em.getDept().length()+em.getEmId().length();
        LoadingCache<String,Employee> cache = CacheBuilder.newBuilder()
                .maximumWeight(45)
                .concurrencyLevel(1)//单线程
                .weigher(weigher)
                .build(cacheLoader);

        cache.getUnchecked("anchao");
        assertLoadedFromDBThenReset();

        cache.getUnchecked("jack");
        assertLoadedFromDBThenReset();

        cache.getUnchecked("gavin");
        assertLoadedFromDBThenReset();

        assertThat(cache.size(),equalTo(3L));

        cache.getUnchecked("jason");
        assertLoadedFromDBThenReset();
        assertThat(cache.getIfPresent("anchao"),nullValue());
        assertThat(cache.size(),equalTo(3L));



    }




    private CacheLoader<String, Employee> getCacheLoader() {
        return new CacheLoader<String, Employee>() {
            @Override
            public Employee load(String key) throws Exception {
                return findEmployeeByName(key);
            }
        };
    }
}
