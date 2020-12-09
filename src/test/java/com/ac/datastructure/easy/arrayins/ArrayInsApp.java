package com.ac.datastructure.easy.arrayins;

/**
 * 测试插入排序
 */
public class ArrayInsApp {

    public static void main(String[] args) {

        int maxSize =100;
        ArrayIns arr;
        arr =new ArrayIns(maxSize);
        arr.insert(11);
        arr.insert(99);
        arr.insert(66);
        arr.insert(88);
        arr.insert(55);
        arr.insert(22);
        arr.insert(44);
        arr.insert(33);
        arr.insert(77);
        arr.insert(77);
        arr.display();
        arr.insertionSort();
        arr.display();

    }
}
