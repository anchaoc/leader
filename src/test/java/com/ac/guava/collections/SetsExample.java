package com.ac.guava.collections;

import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** set集合工具
 * @author anchao
 * @date 2020/3/8 21:10
 */
public class SetsExample {


    //sets 笛卡尔积
    @Test
    public void cartesianProduct(){
        HashSet<Integer> hashSet = Sets.newHashSet(1, 2, 3);
        Set<List<Integer>> lists = Sets.cartesianProduct(hashSet);
        //[[1, 1], [1, 2], [1, 3], [2, 1], [2, 2], [2, 3], [3, 1], [3, 2], [3, 3]]
        System.out.println(lists);
    }

    //combinations 依次组合搭配(子集)
    @Test
    public void combinations(){
        HashSet<Integer> hashSet = Sets.newHashSet(1, 2, 3,4);
        Set<Set<Integer>> combinations = Sets.combinations(hashSet, 2);
        /**
         * [1, 2]
         * [1, 3]
         * [2, 3]
         * [1, 4]
         * [2, 4]
         * [3, 4]
         */
        combinations.forEach(System.out::println);
    }

    //difference 求差异 也就是取差集
    @Test
    public void difference(){
        HashSet<Integer> hashSet1 = Sets.newHashSet(1, 2, 3);
        HashSet<Integer> hashSet2 = Sets.newHashSet(1, 4, 5);
        Sets.SetView<Integer> difference1 = Sets.difference(hashSet2,hashSet1);
        Sets.SetView<Integer> difference2 = Sets.difference(hashSet1,hashSet2);
        System.out.println(difference1);
        System.out.println(difference2);
    }

    //交集
    @Test
    public void intersection(){
        HashSet<Integer> hashSet1 = Sets.newHashSet(1, 2, 3);
        HashSet<Integer> hashSet2 = Sets.newHashSet(1, 4, 5);
        Sets.SetView<Integer> intersection = Sets.intersection(hashSet2,hashSet1);
        System.out.println(intersection);
    }

    //union 并集
    @Test
    public void union(){
        HashSet<Integer> hashSet1 = Sets.newHashSet(1, 2, 3);
        HashSet<Integer> hashSet2 = Sets.newHashSet(1, 4, 5);
        Sets.SetView<Integer> union = Sets.union(hashSet1, hashSet2);
        System.out.println(union);
    }

    //补充枚举类型
    @Test
    public void complementOf(){
        HashSet<TT> hashSet = Sets.newHashSet(TT.A);
        EnumSet<TT> tts = Sets.complementOf(hashSet);
        //B
        //C
        tts.forEach(System.out::println);

    }



    public enum TT{
        A,B,C
    }



}
