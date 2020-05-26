package com.ac.jdkresources.util.observer;

/**
 * @author anchao
 * @date 2020/5/26 10:06
 **/
public class ObserverTest {

    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.setTeacherName("刘老师");
        Student student = new Student();
        student.setStudentName("小明");
        student.addObserver(teacher);
        student.updateStudentName("大明");
    }
}
