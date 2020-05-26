package com.ac.hutool;

import cn.hutool.core.convert.Convert;

/**
 * @author anchao
 * @date 2020/5/12 15:04
 **/
public class ConvertTest {
    public static void main(String[] args) {
        int a =233;
        String convertStr = Convert.convert(String.class, null, "1");
        System.out.println(convertStr);
    }
}
