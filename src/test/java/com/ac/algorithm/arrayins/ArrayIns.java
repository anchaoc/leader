package com.ac.algorithm.arrayins;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 插入排序数组
 */
public class ArrayIns {

    /**声明数组*/
    private long[] a;

    /**数组元素总数*/
    private int nElems;

    public ArrayIns(int max) {
        a =new long[max];
        nElems =0;
    }

    /**
     * 新增
     * @param value
     */
    public void insert(long value){
        a[nElems] = value;
        nElems++;
    }

    /**
     * 显示
     */
    public void display(){
        for (int i = 0; i <nElems ; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }

    /**
     * 插入排序
     */
    public void insertionSort(){
        new CopyOnWriteArrayList<>();
        int out,in;
        for (out=1;out<nElems;out++){
            long temp = a[out];
            in = out;
            //从小到大排序
            while(in>0 && a[in-1]>=temp){
                a[in] = a[in-1];
                in--;
            }
            //从大到小排序
//            while(in>0 && a[in-1]<=temp){
//                a[in] = a[in-1];
//                in--;
//            }
            a[in] = temp;
        }

    }



}
