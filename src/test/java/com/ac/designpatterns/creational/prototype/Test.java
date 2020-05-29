package com.ac.designpatterns.creational.prototype;

import java.util.Date;

/**
 * 原型模式
 * @author anchao
 * @date 2020/5/29 9:53
 **/
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Pig pig = new Pig();
        pig.setBirthday(new Date(0L));
        pig.setName("佩奇");
        Pig pigClone = (Pig)pig.clone();
        pigClone.setName("小猪");
        pigClone.getBirthday().setTime(99999999L);
        System.out.println(pig);
        System.out.println(pigClone);
    }
}
