package com.ac.jdk.juc.lock.lock;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述：     TODO
 */
public class PessimismOptimismLock {

    int a;

    public static void main(String[] args) {
        //乐观
        AtomicInteger atomicInteger = new AtomicInteger(1);
        atomicInteger.compareAndSet(1, 5);
        System.out.println(atomicInteger.get());
    }

    //悲观
    public synchronized void testMethod() {
        a++;
    }


}
