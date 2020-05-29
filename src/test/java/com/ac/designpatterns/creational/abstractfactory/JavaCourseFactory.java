package com.ac.designpatterns.creational.abstractfactory;


/**
 * @author anchao
 * @date 2020/5/29 17:55
 **/
public class JavaCourseFactory implements CourseFactory {
    @Override
    public Video getVideo() {
        return new JavaVideo();
    }

    @Override
    public Article getArticle() {
        return new JavaArticle();
    }
}
