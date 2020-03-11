package com.ac.guava.eventbus;

import com.ac.guava.eventbus.listeners.ConcreteListener;
import com.google.common.eventbus.EventBus;

/**
 * @author anchao
 * @date 2020/3/11 11:54
 */
public class InheritListenerEventbusExample {

    public static void main(String[] args) {

        final EventBus eventBus = new EventBus();
        eventBus.register(new ConcreteListener());
        System.out.println("post the String event ...");
        eventBus.post("I am string event");
        System.out.println("post the int event ...");
        eventBus.post(1000);


    }
}
