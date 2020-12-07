package com.ac.leader.maintest;

/**
 * @author anchao
 * @date 2020/12/5 14:28
 **/
public class DoubleTest {

    public DoubleTest(Object obj) {
        System.out.println("obj");
    }
    public DoubleTest(Double obj) {
        System.out.println("double[]");
    }

    public static void main(String[] args) {
        new DoubleTest(11.2);
    }
}
