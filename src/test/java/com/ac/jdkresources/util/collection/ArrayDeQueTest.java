package com.ac.jdkresources.util.collection;

import java.util.ArrayDeque;

/**
 * @author anchao
 * @date 2020/5/6 15:25
 **/
public class ArrayDeQueTest {
    public static void main(String[] args) {
        //作为栈使用 后进先出
        ArrayDeque<Long> longArrayDeque = new ArrayDeque<>();
        longArrayDeque.addFirst(8L);
        longArrayDeque.addFirst(7L);
        longArrayDeque.addFirst(9L);
        for (Long aLong : longArrayDeque) {
            System.out.println(aLong);
        }

    }
}
