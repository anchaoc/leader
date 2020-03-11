package com.ac.guava.eventbus;

import com.ac.guava.eventbus.events.Apple;
import com.ac.guava.eventbus.events.Fruit;
import com.ac.guava.eventbus.listeners.FruitEaterListener;
import com.google.common.eventbus.EventBus;

/**
 * @author anchao
 * @date 2020/3/11 11:54
 */
public class InheritListenerEaterEventbusExample {

    public static void main(String[] args) {

        final EventBus eventBus = new EventBus();
        eventBus.register(new FruitEaterListener());
        eventBus.post(new Apple("红富士"));
        System.out.println("------------------------>");
        eventBus.post(new Fruit("红富士"));


    }
}
