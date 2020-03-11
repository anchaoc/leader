package com.ac.guava.eventbus.listeners;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.Subscribe;

/**
 * @author anchao
 * @date 2020/3/11 14:11
 */
public class DeadEventListener {

    @Subscribe
    public void handle(DeadEvent event){

        System.out.println("--->"+event.getSource());
        System.out.println("--->"+event.getEvent());

    }
}
