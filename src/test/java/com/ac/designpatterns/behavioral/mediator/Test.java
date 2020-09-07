package com.ac.designpatterns.behavioral.mediator;

/**
 *  行为型--中介者模式
 * @author anchao
 * @date 2020/9/7 17:20
 **/
public class  Test {

    public static void main(String[] args) {
        User an_chao = new User("An chao");
        User li_lei = new User("li lei");

        an_chao.sendMessage("你好");
        li_lei.sendMessage("hello");
    }
}
