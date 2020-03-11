package com.ac.guava.eventbus;

import com.ac.guava.eventbus.listeners.DeadEventListener;
import com.google.common.eventbus.EventBus;

/**
 * @author anchao
 * @date 2020/3/11 14:12
 */
public class DeadEventBusExample {


    public static void main(String[] args) {
        DeadEventListener deadEventListener = new DeadEventListener();
        final EventBus eventBus = new EventBus("Dead Event Bus"){
            @Override
            public String toString() {
                return "Dead Event Bus";
            }
        };
        eventBus.register(deadEventListener);
        eventBus.post("Hello1");
        eventBus.post("Hello2");

        eventBus.unregister(deadEventListener);
        eventBus.post("Hello3");
        eventBus.post("Hello4");
    }
}
