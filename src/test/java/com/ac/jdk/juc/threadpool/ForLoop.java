package com.ac.jdk.juc.threadpool;

/**
 * 描述：     TODO
 */
public class ForLoop {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new Task());
            thread.start();
        }
    }

    static class Task implements Runnable {

        @Override
        public void run() {
            System.out.println("执行了任务");
        }
    }

}
