package com.ac.datastructure.easy.arrayselect;

/**
 * 选择排序数组
 */
public class ArraySel {

    /**声明数组*/
    private long[] a;

    /**数组元素总数*/
    private int nElems;

    public ArraySel(int max) {
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
     * 选择排序
     */
    public void selectionSort(){
        int out,in,min;
        for (out=0;out<nElems;out++){
            min = out;
            for (in=out+1;in<nElems;in++){
                if(a[in] < a[min]) min = in; //从小到大
                //if(a[in] >a[min]) min = in; //从大到小
            }
            swap(out,min);
        }
    }

    /**
     * 交换位置
     * @param one
     * @param two
     */
    private void swap(int one, int two) {
        long temp =a[one];
        a[one] = a[two];
        a[two] = temp;
    }
}

