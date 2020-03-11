package com.ac.guava.eventbus;

import com.ac.guava.eventbus.listeners.MultipleEventListenters;
import com.google.common.eventbus.AsyncEventBus;

import java.util.concurrent.Executors;

/** 事件发送
 * @author anchao
 * @date 2020/3/11 11:43
 */
public class MultipleEventBusExample {

    public static void main(String[] args) {
        //异步
        final AsyncEventBus eventBus = new AsyncEventBus(Executors.newFixedThreadPool(100));
        eventBus.register(new MultipleEventListenters());

        System.out.println("post the String event ...");
        eventBus.post("I am string event");
        System.out.println("post the int event ...");
        eventBus.post(1000);


    }



}
