package com.ac.jdk.io.serializable.test;

import com.ac.jdk.io.serializable.singleton.UserSingleton;

/**
 * @author anchao
 * @date 2020/4/26 16:58
 **/
public class UserSingletonTest {

    public static void main(String[] args) {
        UserSingleton userSingleton1 = UserSingleton.getUserSingleton();
        UserSingleton userSingleton2 = UserSingleton.getUserSingleton();
        System.out.println(userSingleton1);
        System.out.println(userSingleton2);
        System.out.println(userSingleton1 == userSingleton2);
    }
}
