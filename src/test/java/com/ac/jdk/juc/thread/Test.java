package com.ac.jdk.juc.thread;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @author anchao
 * @date 2020/12/7 19:36
 **/
public class Test {
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    // 打印ABABC
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

    //模拟三个线程调用服务，使用最快的线程拿到结果就跳出
    public static void accept() throws ExecutionException, InterruptedException {
        ThreadPoolExecutor executorService = (ThreadPoolExecutor)Executors.newFixedThreadPool(3);
        ArrayList<Future> arrayList = new ArrayList<>(3);
        Future<Object> submit = null;
        for (int i = 1; i <=3; i++) {
            int h = i*100;
            submit = executorService.submit(() -> {
                Thread.sleep(h);
                return Thread.currentThread().getName();
            });
            arrayList.add(submit);
        }
        point :
        {
            while (executorService.getCompletedTaskCount() < arrayList.size()) {
                for (int i = 0; i < arrayList.size(); i++) {
                    Future submitFuture = arrayList.get(i);
                    if (submitFuture.isDone()) {
                        System.out.println("最快 ：" + submitFuture.get());
                        break point;
                    }
                }
            }
        }

        Thread.sleep(1000);
        System.out.println("over");
        executorService.shutdown();
    }


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        accept();
    }
}
