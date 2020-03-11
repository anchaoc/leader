package com.ac.guava.eventbus;

import com.ac.guava.eventbus.listeners.MultipleEventListenters;
import com.google.common.eventbus.EventBus;

/** 事件发送
 * @author anchao
 * @date 2020/3/11 11:43
 */
public class MultipleEventBusExample {

    public static void main(String[] args) {

        final EventBus eventBus = new EventBus();
        eventBus.register(new MultipleEventListenters());

        System.out.println("post the String event ...");
        eventBus.post("I am string event");
        System.out.println("post the int event ...");
        eventBus.post(1000);


    }



}
