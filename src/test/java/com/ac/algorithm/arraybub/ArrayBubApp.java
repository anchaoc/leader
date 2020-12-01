package com.ac.algorithm.arraybub;
/**
 * 测试冒泡排序数组
 */
public class ArrayBubApp {

    public static void main(String[] args) {

        int maxSize =100;
        ArrayBub arr;
        arr =new ArrayBub(maxSize);
        arr.insert(11);
        arr.insert(99);
        arr.insert(66);
        arr.insert(88);
        arr.insert(55);
        arr.insert(22);
        arr.insert(44);
        arr.insert(33);
        arr.insert(77);
        arr.insert(45);
        arr.display();
        arr.bubbleSort();
        arr.display();

    }
}
