package com.ac.designpatterns.creational.factorymethod;

/**
 * @author anchao
 * @date 2020/5/29 17:26
 **/
public class JavaVideoFactory extends VideoFactory {

    @Override
    public Video getVideo() {
        return new JavaVideo();
    }


}
