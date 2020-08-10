package com.ac.designpatterns.behavioral.visitor;

/**
 * @author anchao
 * @date 2020/8/10 13:52
 **/
public abstract class Course {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void accept(IVisitor visitor);
}
