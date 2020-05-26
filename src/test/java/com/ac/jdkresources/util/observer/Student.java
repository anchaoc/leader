package com.ac.jdkresources.util.observer;

import lombok.Data;

import java.util.Observable;

/**
 * @author anchao
 * @date 2020/5/26 9:58
 **/
@Data
public class Student extends Observable {
    private String studentName;



    public void updateStudentName(String studentName){
        this.studentName = studentName;
        super.setChanged();
        super.notifyObservers(studentName);
    }
}
