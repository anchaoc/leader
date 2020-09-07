package com.ac.designpatterns.behavioral.mediator;

import java.time.LocalDateTime;

/**
 * 学习群
 * @author anchao
 * @date 2020/9/7 17:21
 **/
public class StudyGroup {
    /**
     * 发言
     * @param user
     * @param message
     */
    public static void showMessage(User user,String message){
        System.out.println(LocalDateTime.now().toString() +" ["+user.getName()+"] "+message);
    }
}
