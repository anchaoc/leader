package com.ac.junit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author anchao
 * @date 2020/8/14 14:26
 **/
public class CalculateTest {



    @Test
    public void testAdd(){
        int add = new Calculate().add(3, 3);
        System.out.println("add:"+add);
       // Assert.assertEquals(4, add);
    }

    @Before
    public void testBefore(){
        System.out.println("junit before method.");
    }
    @After
    public void after(){
        System.out.println("junit after method.");
    }
}
