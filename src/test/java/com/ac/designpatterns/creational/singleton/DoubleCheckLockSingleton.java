package com.ac.designpatterns.creational.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/** 双重检查锁单例
 * 并发场景线程安全
 * @author anchao
 * @date 2020/5/27 10:01
 **/
public class DoubleCheckLockSingleton {
    private static DoubleCheckLockSingleton doubleCheckLockSingleton = null;


    public static DoubleCheckLockSingleton getInstance() {
        if (doubleCheckLockSingleton == null) {
            synchronized (DoubleCheckLockSingleton.class){
                if (doubleCheckLockSingleton == null) {
                    doubleCheckLockSingleton = new DoubleCheckLockSingleton();
                }
            }
        }
        return doubleCheckLockSingleton;
    }
    private static boolean flag=true;
    private DoubleCheckLockSingleton() {
        if(flag){
            flag =false;
        }else{
            throw new RuntimeException("单例构造器禁止反射");
        }
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        //反射修改单例
        DoubleCheckLockSingleton doubleCheckLockSingleton = DoubleCheckLockSingleton.getInstance();
        Class objectClass = DoubleCheckLockSingleton.class;
        Constructor declaredConstructor = objectClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Field flag = doubleCheckLockSingleton.getClass().getDeclaredField("flag");
        flag.setAccessible(true);
        flag.set(doubleCheckLockSingleton,true);
        DoubleCheckLockSingleton doubleCheckLockSingletonNew = (DoubleCheckLockSingleton)declaredConstructor.newInstance();
        System.out.println(doubleCheckLockSingleton == doubleCheckLockSingletonNew);



    }
}
