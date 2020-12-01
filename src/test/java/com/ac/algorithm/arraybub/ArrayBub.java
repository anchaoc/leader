package com.ac.algorithm.arraybub;

/**
 * 冒泡排序数组
 */
public class ArrayBub {

    /**声明数组*/
    private long[] a;

    /**数组元素总数*/
    private int nElems;

    public ArrayBub(int max) {
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
     * 冒泡排序
     */
    public void bubbleSort(){
        int i =0;
        int c =0;
        int out,in;   //定义外层初始下标,内层初始循环下标
        for (out =nElems-1;out>1;out--) {
            i++;
            for (in=0; in<out ; in++) {
                c++;
                if(a[in]>a[in+1]) swap(in,in+1); //从小到大排序
                //if(a[in]<a[in+1]) swap(in,in+1); //从大到小排序
            }
        }
//        System.out.println("外层循环次数:"+i);
//        System.out.println("内层循环次数:"+c);
//        int m =c+i;
//        System.out.println("共循环次数:"+m);
    }

    /**
     * 交换位置
     * @param one
     * @param two
     */
    private void swap(int one,int two) {
        long temp =a[one];
        a[one] = a[two];
        a[two] = temp;

    }

}
