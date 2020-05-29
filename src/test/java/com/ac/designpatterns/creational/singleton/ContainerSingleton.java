package com.ac.designpatterns.creational.singleton;

import org.junit.platform.commons.util.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 容器单例
 * @author anchao
 * @date 2020/5/27 18:08
 **/
public class ContainerSingleton {
    private ContainerSingleton(){};
    private static Map<String, Object> singletonMap = new ConcurrentHashMap<>();

    public static void putInstance(String key,Object instance){
        if (StringUtils.isNotBlank(key) && instance !=null) {
            if (!singletonMap.containsKey(key)) {
                singletonMap.put(key, instance);
            }
        }
    }

    public static Object getInstance(String key){
        return singletonMap.get(key);
    }

}
