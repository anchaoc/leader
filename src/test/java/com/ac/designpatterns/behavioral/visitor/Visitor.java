package com.ac.designpatterns.behavioral.visitor;

/**
 * @author anchao
 * @date 2020/8/10 13:58
 **/
public class Visitor implements IVisitor {

    @Override
    public void visit(CodingCourse codingCourse) {
        System.out.println("实战课程"+codingCourse.getName()+"，价格："+codingCourse.getPrice());
    }

    @Override
    public void visit(FreeCourse freeCourse) {
        System.out.println("免费课程："+freeCourse.getName());
    }
}
