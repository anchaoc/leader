package com.ac.jdk.juc.collections.concurrenthashmap;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 描述：     TODO
 */
public class ConcurrentHashMapDemo {
    public static final ConcurrentHashMap<String,String> c =  new ConcurrentHashMap<>();

    public static void main(String[] args) {
        c.put("","");
        c.putIfAbsent("", "");
        c.replace("", "", "");
    }
}
