package com.ac.guava.collections;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.junit.Test;

/** 不可变 修改会异常
 * @author anchao
 * @date 2020/3/10 15:12
 */
public class ImmutableMapExample {

    @Test
    public void testOf(){
        ImmutableList<Integer> immutableList = ImmutableList.of(1, 2, 3);
        //[1, 2, 3]
        System.out.println(immutableList);
        immutableList.add(4);//异常

    }

    @Test
    public void testCopyOf(){
        Integer[] integers = {1,2,3};
        ImmutableList<Integer> integerImmutableList = ImmutableList.copyOf(integers);
        //[1, 2, 3]
        System.out.println(integerImmutableList);
    }

    @Test
    public void testBuilder(){
        ImmutableList.Builder<Integer> builder = ImmutableList.builder();
        ImmutableList<Integer> build = builder.add(1).add(2).add(3).build();
        //[1, 2, 3]
        System.out.println(build);
    }

    @Test
    public void testSortedCopyOf(){
        ImmutableList<Integer> build = ImmutableList.of(1, 2, 3);
        //支持排序
        ImmutableList<Integer> integers = ImmutableList.sortedCopyOf((o1, o2) -> o2 - o1, build);
        System.out.println(integers);
    }

    @Test
    public void testImmutableMap(){
        ImmutableMap<String, String> immutableMap = ImmutableMap.of("Java", "1.8");
        System.out.println(immutableMap);

        ImmutableMap.Builder<Object, Object> objectBuilder = ImmutableMap.builder().put("Oracle", "12c");

        ImmutableMap<Object, Object> build = objectBuilder.build();

        System.out.println(build);

    }
}
