package com.ac.designpatterns.structural.composite;

import java.math.BigDecimal;

/**
 * @author anchao
 * @date 2020/8/11 10:50
 **/
public class Course extends CatalogComponent {

    private String name;
    private BigDecimal price;

    public Course(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String getName(CatalogComponent catalogComponent) {
        return this.name;
    }

    @Override
    public BigDecimal getPrice(CatalogComponent catalogComponent) {
        return this.price;
    }

    @Override
    public void print() {
        System.out.println("Course Name :"+name+" Price:"+price);
    }
}
