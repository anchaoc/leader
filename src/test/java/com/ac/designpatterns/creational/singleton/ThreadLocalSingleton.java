package com.ac.designpatterns.creational.singleton;

/**
 * 线程单例
 * 以空间换时间的方式实现
 * @author anchao
 * @date 2020/5/27 18:22
 **/
public class ThreadLocalSingleton {
    private ThreadLocalSingleton() {
    }

    private static final ThreadLocal<ThreadLocalSingleton> threadLocal
            = ThreadLocal.withInitial(ThreadLocalSingleton::new);

    public static ThreadLocalSingleton getInstance(){
        return threadLocal.get();
    }



}
