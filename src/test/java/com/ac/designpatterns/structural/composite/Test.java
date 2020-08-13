package com.ac.designpatterns.structural.composite;

import java.math.BigDecimal;

/**
 * 结构型--组合模式
 * @author anchao
 * @date 2020/8/11 10:57
 **/
public class Test {


    public static void main(String[] args) {
        CatalogComponent linuxCourse = new Course("Linux课程", new BigDecimal("11"));
        CatalogComponent windowsCourse = new Course("Windows课程", new BigDecimal("11"));

        CatalogComponent javaCourseCatalog = new CourseCatalog("Java课程目录");
        CatalogComponent mmallCourse1 = new Course("Java电商一期", new BigDecimal("55"));
        CatalogComponent mmallCourse2 = new Course("Java电商二期", new BigDecimal("66"));
        CatalogComponent designPattern = new Course("Java设计模式", new BigDecimal("77"));

        javaCourseCatalog.add(mmallCourse1);
        javaCourseCatalog.add(mmallCourse2);
        javaCourseCatalog.add(designPattern);

        CatalogComponent immoocMainCourseCatalog = new CourseCatalog("慕课网课程主目录");
        immoocMainCourseCatalog.add(linuxCourse);
        immoocMainCourseCatalog.add(windowsCourse);
        immoocMainCourseCatalog.add(javaCourseCatalog);

        immoocMainCourseCatalog.print();


    }
}
