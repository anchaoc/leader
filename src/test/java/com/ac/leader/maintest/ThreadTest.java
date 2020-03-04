package com.ac.leader.maintest;

import lombok.extern.slf4j.Slf4j;

/**
 * @author anchao
 * @date 2020/3/4 20:39
 */
@Slf4j
public class ThreadTest {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> log.info("线程名称--->"+Thread.currentThread().getName()));
        Thread thread2 = new Thread(() -> log.info("线程名称--->"+Thread.currentThread().getName()));
        Thread thread3 = new Thread(() -> log.info("线程名称--->"+Thread.currentThread().getName()));
        Thread thread4 = new Thread(() -> log.info("线程名称--->"+Thread.currentThread().getName()));
        thread.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
