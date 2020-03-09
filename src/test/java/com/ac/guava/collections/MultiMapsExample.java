package com.ac.guava.collections;

import com.google.common.collect.LinkedListMultimap;
import org.junit.Test;

/**
 * @author anchao
 * @date 2020/3/9 18:20
 */
public class MultiMapsExample {


    @Test
    public void test(){
        //一个KEY对应多个value
        LinkedListMultimap<String, String> multimap = LinkedListMultimap.create();
        multimap.put("1","2");
        multimap.put("1","3");
        //{1=[2, 3]}
        System.out.println(multimap);

    }
}
