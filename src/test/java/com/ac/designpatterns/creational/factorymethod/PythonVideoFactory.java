package com.ac.designpatterns.creational.factorymethod;

/**
 * @author anchao
 * @date 2020/5/29 17:27
 **/
public class PythonVideoFactory extends VideoFactory {
    @Override
    public Video getVideo() {
        return new PythonVideo();
    }
}
