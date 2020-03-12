package com.ac.guava.concurrent;

import com.google.common.util.concurrent.*;

import javax.annotation.Nullable;
import java.util.concurrent.*;

/**
 * @author anchao
 * @date 2020/3/12 12:35
 */
public class ListenableFutureExample {


    public static void main(String[] args) {
        //jdkFuture();
        //guavaMoreExecutors();
        //futureCallback();

        jdk8Future();

    }

    //jdk8 future 获取异步结果 不阻塞主线程
    private static void jdk8Future() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(()->{
            try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return 100;

        },executorService);

        future.whenComplete((v,t)->{
            System.out.println("I am finished result is "+v);
        });
        System.out.println(".......................................");
    }


    // Futures 获取异步执行结果 不阻塞主线程
    private static void futureCallback() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(executorService);

        ListenableFuture<Integer> future = listeningExecutorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10;
        });

        Futures.addCallback(future,new MycallBack(),executorService);
        System.out.println("<------------->");
    }


    static class MycallBack implements FutureCallback<Integer>{


        @Override
        public void onSuccess(@Nullable Integer result) {
            System.out.println("I am finished result is "+result);
        }

        @Override
        public void onFailure(Throwable t) {
            System.out.println("I am finished error  "+t);
        }
    }







    //guava future 异步非阻塞 获取返回
    private static void guavaMoreExecutors(){
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        ListeningExecutorService listeningExecutorService = MoreExecutors.listeningDecorator(executorService);

        ListenableFuture<Integer> future = listeningExecutorService.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10;
        });

        future.addListener(()-> {
            try {
                Integer integer = future.get();
                System.out.println(" future return "+integer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        },executorService);
        System.out.println("------------不用等待获取就会输出------------->");
    }


    //jdk 阻塞获取返回
    private static void jdkFuture() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Integer> future = executorService.submit(() -> {

            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10;
        });

        Object object = null;
        try {
            object = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(object);
        System.out.println("----------获取后才会输出--------------->");
    }
}
