package com.ac.designpatterns.creational.factorymethod;

/**
 * @author anchao
 * @date 2020/5/29 17:29
 **/
public class FEVideo extends Video {
    @Override
    public void produce() {
        System.out.println("录制前端课程视频");
    }
}
