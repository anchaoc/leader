package com.ac.jdk.io.serializable.singleton;

import java.io.Serializable;

/**
 * 线程安全防止序列化破坏的单例对象
 *
 * @author anchao
 * @date 2020/4/26 16:53
 **/
public class UserSingleton implements Serializable {
    private static final long serialVersionUID = 8866702213395896779L;
    private volatile static UserSingleton userSingleton;

    public static UserSingleton getUserSingleton() {
        if (userSingleton == null) {
            synchronized (UserSingleton.class) {
                if (userSingleton == null) {
                    userSingleton = new UserSingleton();
                }
            }
        }
        return userSingleton;
    }


    private Object readResolve() {
        return userSingleton;
    }

}
