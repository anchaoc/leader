package com.ac.designpatterns.behavioral.mediator;

/**
 * @author anchao
 * @date 2020/9/7 17:20
 **/
public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }

    public void sendMessage(String message){
        StudyGroup.showMessage(this,message);
    }
}
