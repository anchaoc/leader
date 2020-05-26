package com.ac.jdk.util.concurrent;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * CountDownLatch是一个同步工具类，
 * 它允许一个或多个线程一直等待，直到其他线程的操作执行完后再执行。
 * 它的实现原理通过一个计数器来实现的，计数器的初始值为线程的数量。
 * 每当一个线程完成了自己的任务后，计数器的值就会减1。
 * 当计数器值到达0时，它表示所有的线程已经完成了任务，然后在闭锁上等待的线程就可以恢复执行任务。
 * @author anchao
 * @date 2020/4/1 15:50
 */
public class CountDownLatchTest {
    private final CountDownLatch countDownLatch =new CountDownLatch(5);



    @Test
    public void countThreadTest(){
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i <5 ; i++) {
            executor.execute(this::print);
        }
        try {
            countDownLatch.await();
            System.out.println("---->多线程执行完毕,主线程继续执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 打印任务
     */
    private void print() {
        try {
            TimeUnit.SECONDS.sleep(5L);
            System.out.println("----->线程："+Thread.currentThread().getName()+"执行任务完成");
            countDownLatch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
