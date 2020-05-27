package com.ac.designpatterns.singleton;

/**
 * 静态内部类方式 单例
 * 是线程安全的
 * 类加载时获取类锁
 * @author anchao
 * @date 2020/5/27 10:58
 **/
public class StaticInnerClassSingleton {
    private StaticInnerClassSingleton() {
    }

    private static class InnerClass {
        private static StaticInnerClassSingleton staticInnerClassSingleton = new StaticInnerClassSingleton();

        private InnerClass() {
            if(staticInnerClassSingleton!=null){
                throw new RuntimeException("单例构造器禁止反射");
            }
        }
    }

    public static StaticInnerClassSingleton getInstance() {
        return InnerClass.staticInnerClassSingleton;
    }
}
