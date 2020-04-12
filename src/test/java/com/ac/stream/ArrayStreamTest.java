package com.ac.stream;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author anchao
 * @date 2020/4/12 22:34
 **/
public class ArrayStreamTest {

    /**
     * int数组转换Integer数组
     */
    @Test
    public void arrayTest(){
        int[] intArr ={9,5,2,7,0};
        Integer[] integersArr = Arrays.stream(intArr).boxed().toArray(Integer[]::new);
        for (Integer integer : integersArr) {
            System.out.println(integer);
        }
    }
}
