package com.ac.guava.collections;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**List 工具
 * @author anchao
 * @date 2020/3/8 20:14
 */
public class ListsExample {


    //产生笛卡尔积 cartesianProduct
    @Test
    public void testCartesianProduct(){
        List<List<String>> result = Lists.cartesianProduct(
                Lists.newArrayList("1", "2"),
                Lists.newArrayList("A", "B")
        );
        System.out.println(result);
    }

    //transform 数据转换
    @Test
    public void testTransForm(){
        ArrayList<String> arrayList = Lists.newArrayList("Guava", "Java", "Anchao");
        List<String> transform = Lists.transform(arrayList, e -> e.toUpperCase());
        System.out.println(transform);
    }

    //定义初始容量集合
    @Test
    public void testNewArrayListWithCapacity(){
        ArrayList<Object> arrayList = Lists.newArrayListWithCapacity(20);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        System.out.println(arrayList);
    }

    //定义计算后初始容量集合
    @Test
    public void testListWithExpectedSize(){
        ArrayList<Integer> arrayList = Lists.newArrayListWithExpectedSize(20);
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(1);
        System.out.println(arrayList);
    }

    //反向
    @Test
    public void testReverse(){
        ArrayList<Integer> arrayList = Lists.newArrayList(1, 2, 3, 4, 5);
        List<Integer> integerList = Lists.reverse(arrayList);
        System.out.println(integerList);

    }

    //Partition分区
    @Test
    public void testPartition(){
        ArrayList<Integer> arrayList = Lists.newArrayList(1, 2, 3, 4, 5);
        List<List<Integer>> partition = Lists.partition(arrayList, 2);
        System.out.println(partition);
    }


}
