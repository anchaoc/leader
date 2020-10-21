package com.ac.jdk.juc.cas;

/**
 * 描述：     模拟CAS操作，等价代码
 */
public class SimulatedCAS {
    private volatile int value;

    public synchronized int compareAndSwap(int expectedValue, int newValue) {
        int oldValue = value;
        if (oldValue == expectedValue) {
            value = newValue;
        }
        return oldValue;
    }


    public static void main(String[] args) {
        SimulatedCAS simulatedCAS = new SimulatedCAS();
        simulatedCAS.value=1;
        int swap = simulatedCAS.compareAndSwap(1, 2);
        System.out.println(swap);
        System.out.println(simulatedCAS.value);
    }
}
