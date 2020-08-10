package com.ac.designpatterns.behavioral.visitor;

/**
 * @author anchao
 * @date 2020/8/10 13:54
 **/
public interface IVisitor {
    /**
     * 访问实战课程
     * @param codingCourse
     */
    void visit(CodingCourse codingCourse);

    /**
     * 访问免费课程
     * @param freeCourse
     */
    void visit(FreeCourse freeCourse);
}
