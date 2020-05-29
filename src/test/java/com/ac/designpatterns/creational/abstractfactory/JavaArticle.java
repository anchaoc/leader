package com.ac.designpatterns.creational.abstractfactory;

/**
 * @author anchao
 * @date 2020/5/29 17:56
 **/
public class JavaArticle extends Article {
    @Override
    public void produce() {
        System.out.println("编写java手记");
    }
}
