package com.ac.designpatterns.creational.factorymethod;

/**
 * @author anchao
 * @date 2020/5/29 16:02
 **/
public class PythonVideo extends Video {
    @Override
    public void produce() {
        System.out.println("录制python视频");
    }
}
