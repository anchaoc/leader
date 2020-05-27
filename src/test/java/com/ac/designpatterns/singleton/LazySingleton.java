package com.ac.designpatterns.singleton;

/**
 * 懒汉式单例
 * 并发场景线程不安全
 * @author anchao
 * @date 2020/5/27 9:58
 **/
public class LazySingleton {
    private static LazySingleton lazySingleton = null;


    public static LazySingleton getInstance() {
        if (lazySingleton == null) {
            lazySingleton = new LazySingleton();
        }
        return lazySingleton;
    }

    private LazySingleton() {
    }

}
