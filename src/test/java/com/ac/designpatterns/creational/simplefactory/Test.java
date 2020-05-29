package com.ac.designpatterns.creational.simplefactory;

/**
 * 简单工厂设计模式
 *
 * @author anchao
 * @date 2020/5/29 16:03
 **/
public class Test {

    public static void main(String[] args) {
        Video video = VideoFactory.getVideo("python");
        //Video video = VideoFactory.getVideo(JavaVideo.class);
        video.produce();
    }
}
