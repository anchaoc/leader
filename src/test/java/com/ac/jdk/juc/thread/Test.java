package com.ac.jdk.juc.thread;

/**
 * @author anchao
 * @date 2020/12/7 19:36
 **/
public class Test {

    // ABABC
    public static void sout() throws InterruptedException {
        for (int i = 0; i < 2; i++) {
          Thread A=  new Thread(()->{
                System.out.print("A");
            });
          Thread B=  new Thread(()->{
                System.out.print("B");
            });
          A.start();
          A.join();
          B.start();
          B.join();
        }
        Thread C=  new Thread(()->{
            System.out.print("C");
        });
        C.start();
    }

    public static void main(String[] args) throws InterruptedException {
        //for (int i = 0; i < 10; i++) {
            sout();
        //}

    }
}
