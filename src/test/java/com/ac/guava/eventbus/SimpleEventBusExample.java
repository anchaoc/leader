package com.ac.guava.eventbus;

import com.ac.guava.eventbus.listeners.SimpleListener;
import com.google.common.eventbus.AsyncEventBus;

import java.util.concurrent.Executors;

/** 事件发送
 * @author anchao
 * @date 2020/3/11 11:34
 */
public class SimpleEventBusExample {

    public static void main(String[] args) {
       //异步事件
      final AsyncEventBus eventBus = new AsyncEventBus(Executors.newFixedThreadPool(10));
        eventBus.register(new SimpleListener());
        System.out.println("post the simple event .");
        eventBus.post("Simple Event");
    }
}
