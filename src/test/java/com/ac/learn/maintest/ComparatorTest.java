package com.ac.learn.maintest;

import com.alibaba.fastjson.JSONObject;

/**
 * @author anchao
 * @date 2020/3/6 13:08
 */
public class ComparatorTest {



    public static void main(String[] args) {
//        List<Integer> integers = Arrays.asList(1, 2, 4, 3, 7, 6, 8);
//        List<Integer> collect = integers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
//        System.out.println(collect);

        JSONObject jsonObject = new JSONObject();
        jsonObject.fluentPut("a","1");
        jsonObject.fluentPut("a","2");
        System.out.println(jsonObject);
    }


}
