package com.ac.designpatterns.creational.factorymethod;

/**
 * 工厂方法设计模式
 *
 * @author anchao
 * @date 2020/5/29 16:03
 **/
public class Test {

    public static void main(String[] args) {
       VideoFactory videoFactory = new FEVideoFactory();
        Video video = videoFactory.getVideo();
        video.produce();
    }
}
