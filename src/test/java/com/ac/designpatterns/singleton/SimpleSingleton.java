package com.ac.designpatterns.singleton;

/**
 * 简单单例实现
 * 线程不安全 且序列化/反射 可破坏单例
 * @author anchao
 * @date 2020/5/26 13:50
 **/
public class SimpleSingleton {
    private static SimpleSingleton ourInstance = new SimpleSingleton();

    public static SimpleSingleton getInstance() {
        return ourInstance;
    }

    private SimpleSingleton() {
    }


    public static void main(String[] args) {
        SimpleSingleton simpleSingleton = SimpleSingleton.getInstance();
        SimpleSingleton simpleSingleton2 = SimpleSingleton.getInstance();
        System.out.println(simpleSingleton == simpleSingleton2);
    }
}
