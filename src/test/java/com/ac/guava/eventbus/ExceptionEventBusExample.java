package com.ac.guava.eventbus;

import com.ac.guava.eventbus.listeners.ExceptionListener;
import com.google.common.eventbus.EventBus;

/**
 * @author anchao
 * @date 2020/3/11 12:14
 */
public class ExceptionEventBusExample {


    public static void main(String[] args) {

        final EventBus eventBus = new EventBus();
        eventBus.register(new ExceptionListener());

        eventBus.post("exception post");

    }
}
