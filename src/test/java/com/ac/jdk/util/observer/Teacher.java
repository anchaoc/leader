package com.ac.jdk.util.observer;

import lombok.Data;

import java.util.Observable;
import java.util.Observer;

/**
 * @author anchao
 * @date 2020/5/26 9:59
 **/
@Data
public class Teacher implements Observer {
    private String teacherName;
    @Override
    public void update(Observable o, Object arg) {
        Student student = (Student)o;
        String studentName = (String) arg;
        System.out.println("观察到："+student+studentName);
    }
}
