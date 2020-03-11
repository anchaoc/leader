package com.ac.guava.concurrent;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.*;
import java.util.stream.IntStream;

import static java.lang.Thread.currentThread;

/** (速率限制)RateLimiter
 * @author anchao
 * @date 2020/3/11 22:55
 */
public class RateLimiterExample {

    //只允许 1秒处理0.5 也就是2秒处理1次  (速率限制)
    private final static RateLimiter limiter = RateLimiter.create(0.5);
    //同一时刻 最多3个线程操作
    private final static Semaphore semaphore = new Semaphore(3);


    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        IntStream range = IntStream.range(0, 10);
        range.forEach((i)->{
            executorService.submit(RateLimiterExample::testSemaphore);
            }
        );

    }


    private static void testSemaphore(){
            try {
                semaphore.acquire();
                System.out.println(currentThread().getName()+" waiting... ");
                int nextInt = ThreadLocalRandom.current().nextInt(10);
                System.out.println("----->nextInt "+nextInt);
                TimeUnit.SECONDS.sleep(nextInt);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            finally {
                semaphore.release();
             }

    }

    private static void testLimiter(){
        limiter.acquire();
        System.out.println(currentThread().getName()+" waiting... ");
    }




}
