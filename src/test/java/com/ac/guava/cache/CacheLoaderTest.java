package com.ac.guava.cache;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author anchao
 * @date 2020/3/10 21:34
 */
@RestController
public class CacheLoaderTest {


    @RequestMapping("cache")
    public List<String>  testLoadNullValue(){
        List<String> stringList = testThreadLocal();
        System.out.println(stringList);
        return stringList;
    }

    private List<String> testThreadLocal() {
        CacheLoaderTest.MyThreadLocal myThreadLocal = new CacheLoaderTest.MyThreadLocal();
        myThreadLocal.set(UUID.randomUUID().toString());
        return myThreadLocal.get();
    }


    static class MyThreadLocal{

        public static List<String> threadList = new ArrayList<>();


        public void set(String s){
            threadList.add(s);
        }


        public List<String> get(){
            return threadList;
        }
    }
}
