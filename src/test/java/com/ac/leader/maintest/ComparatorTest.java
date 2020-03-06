package com.ac.leader.maintest;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author anchao
 * @date 2020/3/6 13:08
 */
public class ComparatorTest {



    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 4, 3, 7, 6, 8);
        List<Integer> collect = integers.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(collect);
    }


}
