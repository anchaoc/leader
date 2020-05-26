package com.ac.hutool;

import cn.hutool.core.clone.CloneSupport;

/**
 * @author anchao
 * @date 2020/5/12 14:56
 **/
public class CloneDataTest extends CloneSupport<CloneDataTest> {


    public static void main(String[] args) {
        CloneDataTest cloneDataTest = new CloneDataTest();
        CloneDataTest cloneDataTestNew = cloneDataTest.clone();
        System.out.println(cloneDataTest == cloneDataTestNew);
        //CloneDataTest clone = ObjectUtil.clone(cloneDataTest);
    }
}
