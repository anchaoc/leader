package com.ac.datastructure.easy.arrayselect;

/**
 * 测试选择排序
 */
public class ArraySelApp {

    public static void main(String[] args) {

        int maxSize =100;
        ArraySel arr;
        arr =new ArraySel(maxSize);
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
        arr.selectionSort();
        arr.display();

    }
}
