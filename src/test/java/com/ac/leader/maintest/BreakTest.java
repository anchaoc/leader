package com.ac.leader.maintest;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author anchao
 * @date 2020/4/26 15:43
 **/
public class BreakTest {


    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 0, 9);
        ArrayList<Integer> integers1 = Lists.newArrayList(integers);
        int size=integers1.size();
        point:{
            for (int i = 0;i < size; i++) {
                System.out.println(2);
                for (int j = 0; j <size ; j++) {
                    break point;
                }
            }
        }
        System.out.println(1);

    }
}
