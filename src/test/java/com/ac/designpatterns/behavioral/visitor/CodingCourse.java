package com.ac.designpatterns.behavioral.visitor;

/**
 * @author anchao
 * @date 2020/8/10 13:52
 **/
public class CodingCourse extends Course {
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
}
