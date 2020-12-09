package com.ac.datastructure.easy.ordarray;

/**
 * 有序数组
 */
public class OrdArray {

    /**声明数组*/
    private long[] a;

    /**数组元素总数*/
    private int nElems;

    /**
     * 二分查找
     * @param searchKey
     * @return
     */
    public int find(long searchKey){

        int lowerBound =0;   //开始索引位置
        int upperBound =nElems-1; //结束索引位置
        int curIn;//需查找的索引位置

        while (true){ //循环到数组末尾
            curIn =(lowerBound+upperBound)/2;//折半
            if(a[curIn] == searchKey) return curIn;//已找到
            else if(lowerBound>upperBound) return nElems;//返回元素总数
            else{
                if(a[curIn] < searchKey) lowerBound = curIn+1;//往后查找 且 开始索引变换
                else upperBound = curIn-1;//往前查找 且 结束索引变换
            }

        }
    }



    /**构造
     * 函数
     * */
    public OrdArray(int max){
        a =new long[max];
        nElems=0;
    }




    /**查看大小
     * 元素个数*/
    public int size(){
        return nElems;
    }



    /**
     * 添加数据项(线性查找)
     * @param value
     */
    public void insert(long value){
        int j;
        for(j=0;j<nElems;j++)
            if(a[j]>value) break;//找到数大 则跳出
        for(int k=nElems;k>j;k--) //倒序循环数组
            a[k]=a[k-1];//数据后移1位
        a[j]=value;//插入
        nElems++;//总数递增
    }

    /**
     * 删除指定数据项
     * @param value
     * @return
     */
    public boolean delete(long value){
        int j = find(value);//二分查找 当前元素索引位置
        if(j == nElems) return false;//无此元素 删除失败
        else{
            for (int k=j;k<nElems;k++)
                a[k] = a[k+1];//向前移1位
            nElems--;//元素总数递减
            return true;
        }
    }


    /**
     * 显示数组中所有数据项
     */
    public void display(){
        for (int i=0;i<nElems;i++){
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }


}
