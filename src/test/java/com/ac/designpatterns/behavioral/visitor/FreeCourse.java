package com.ac.designpatterns.behavioral.visitor;

/**
 * @author anchao
 * @date 2020/8/10 13:52
 **/
public class FreeCourse extends Course {
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
