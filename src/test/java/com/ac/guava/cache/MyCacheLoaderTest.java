package com.ac.guava.cache;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/** 自定义 list 缓存
 * @author anchao
 * @date 2020/3/10 21:34
 */
@RestController
public class MyCacheLoaderTest {


    @RequestMapping("cache")
    public List<String>  testLoadNullValue(){
        List<String> stringList = testThreadLocal();
        System.out.println(stringList);
        return stringList;
    }

    private List<String> testThreadLocal() {
        MyCacheLoaderTest.MyThreadLocal myThreadLocal = new MyCacheLoaderTest.MyThreadLocal();
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
