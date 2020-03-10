package com.ac.guava.collections;

import com.google.common.collect.Ordering;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author anchao
 * @date 2020/3/10 16:01
 */
public class OrderingExample {

    //jdk排序 null不会处理异常
    @Test
    public void testJDKOrder(){
        List<Integer> asList = Arrays.asList(7, 2, 3, null,4, 5, 6);
        Collections.sort(asList);
        System.out.println(asList);
    }

    //Ordering null会处理 不会异常
    @Test
    public void testOrderNatural(){
        List<Integer> asList = Arrays.asList(7, 2, 3, null,4, 5, 6);
        Collections.sort(asList, Ordering.natural().nullsLast());
        System.out.println(asList);
    }

    //验证排序方式 自然顺序
    @Test
    public void testOrderNaturalIsOrdered(){
        List<Integer> asList = Arrays.asList(7, 2, 3,4, 5, 6);
        Collections.sort(asList);
        System.out.println(asList);
        //是否按自然顺序
        System.out.println(Ordering.natural().isOrdered(asList));
    }

    //Ordering.natural().reverse() 倒序
    @Test
    public void testOrderNaturalReverse(){
        List<Integer> asList = Arrays.asList(7, 2, 3,4, 5, 6);
        Collections.sort(asList,Ordering.natural().reverse());
        System.out.println(asList);
    }


}


