package com.ac.jdk.juc.thread;

/**
 * @author anchao
 * @date 2020/12/14 22:53
 **/
public class ThreadTest{




    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> System.out.println("执行业务去了 1"));
        thread1.start();


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行业务去了 2");
            }
        });
        thread2.start();
    }


}
