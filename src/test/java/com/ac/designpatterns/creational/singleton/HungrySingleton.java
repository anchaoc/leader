package com.ac.designpatterns.creational.singleton;

import java.io.Serializable;

/**
 * 饿汉式单例实现
 * 不存在线程不安全问题 且序列化/反射 可破坏单例
 *
 * @author anchao
 * @date 2020/5/26 13:50
 **/
public class HungrySingleton implements Serializable {
    private static HungrySingleton ourInstance = new HungrySingleton();

    public static HungrySingleton getInstance() {
        return ourInstance;
    }

    /**
     * 防止反射破坏单例
     */
    private HungrySingleton() {
        if(ourInstance!=null){
            throw new RuntimeException("单例构造器禁止反射");
        }
    }

    /**
     * 防止反射/序列化破坏单例（已经生成新对象但没返回）
     * @see java.io.ObjectInputStream
     */
    private Object readResolve() {
        return ourInstance;
    }
}
