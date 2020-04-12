package com.ac.jdkresources.lang;

import org.junit.Test;

/**
 * @author anchao
 * @description
 * @date 2020/4/12 19:08
 **/
public class StringTest {

    @Test
    public void stringTest(){
        String st1 = "abc";
        String st2 = "abc";
        System.out.println(st1 == st2);
        System.out.println(st1.equals(st2));
    }

    @Test
    public void stringTest2(){
        String st1 = new String("abc");
        String st2 = "abc";
        System.out.println(st1 == st2);
        System.out.println(st1.equals(st2));
    }

    @Test
    public void stringTest3(){
        String st1 = "ab";
        String st2 = "abc";
        String st3 = st1 + "c";
        System.out.println(st2 == st3);
        System.out.println(st2.equals(st3));
    }
}
