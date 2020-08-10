package com.ac.designpatterns.behavioral.visitor;

import com.google.common.collect.Lists;

import java.util.ArrayList;

/**
 * 行为型--访问者模式
 * @author anchao
 * @date 2020/8/10 14:00
 **/
public class Test {
    public static void main(String[] args) {
        ArrayList<Course> courseArrayList = Lists.newArrayList();

        FreeCourse freeCourse = new FreeCourse();
        freeCourse.setName("英语单词-免费课程");

        CodingCourse codingCourse = new CodingCourse();
        codingCourse.setName("英语语法-实战课程");
        codingCourse.setPrice(199);

        courseArrayList.add(freeCourse);
        courseArrayList.add(codingCourse);

        for (Course course : courseArrayList) {
            course.accept(new Visitor());
        }


    }

}
