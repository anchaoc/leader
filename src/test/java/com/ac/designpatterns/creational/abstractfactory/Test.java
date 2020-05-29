package com.ac.designpatterns.creational.abstractfactory;

/**
 * 抽象工厂设计模式
 * @author anchao
 * @date 2020/5/29 17:59
 **/
public class Test {
    public static void main(String[] args) {
        CourseFactory courseFactory= new JavaCourseFactory();
        Video video = courseFactory.getVideo();
        Article article = courseFactory.getArticle();
        video.produce();
        article.produce();
    }
}
