package com.ac.designpatterns.creational.factorymethod;

/**
 * @author anchao
 * @date 2020/5/29 16:01
 **/
public class JavaVideo extends Video {
    @Override
    public void produce() {
        System.out.println("录制java课程视频");
    }
}
