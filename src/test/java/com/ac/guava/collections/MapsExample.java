package com.ac.guava.collections;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

/**
 * @author anchao
 * @date 2020/3/9 0:01
 */
public class MapsExample {


    //创建
    @Test
    public void testCreate(){
        ArrayList<Integer> arrayList = Lists.newArrayList(1, 2, 4);
        //长度不可变Map
        ImmutableMap<String, Integer> map = Maps.uniqueIndex(arrayList, k -> k + "_KEY");
        System.out.println(map);
    }

    //map元素转换
    @Test
    public void testTransForm(){
        Map<String, String> stringStringMap = Maps.asMap(Sets.newHashSet("1", "2", "3"), k -> k + "_V");
        System.out.println(stringStringMap);
        Map<String, String> stringStringMap1 = Maps.transformValues(stringStringMap, v -> v + "_2V");
        System.out.println(stringStringMap1);
    }

    //过滤
    @Test
    public void testFilter(){
        Map<String, String> stringStringMap = Maps.asMap(Sets.newHashSet("1", "2", "3"), k -> k + "_V");
        Map<String, String> map2 = Maps.filterKeys(stringStringMap, k -> Lists.newArrayList("1", "2").contains(k));
       //{1=1_V, 2=2_V}
        System.out.println(map2);
    }



}
