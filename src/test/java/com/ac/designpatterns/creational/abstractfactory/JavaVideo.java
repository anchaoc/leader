package com.ac.designpatterns.creational.abstractfactory;

/**
 * @author anchao
 * @date 2020/5/29 17:56
 **/
public class JavaVideo extends Video {
    @Override
    public void produce() {
        System.out.println("录制java视频");
    }
}
