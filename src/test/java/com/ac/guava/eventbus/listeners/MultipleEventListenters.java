package com.ac.guava.eventbus.listeners;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/** 事件监听
 * @author anchao
 * @date 2020/3/11 11:40
 */
@Slf4j
public class MultipleEventListenters {

    @Subscribe
    public void task1(final String event){
        try {
            TimeUnit.SECONDS.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(log.isInfoEnabled()){
            log.info("Received event[{}] and will take action by task1()",event);
        }
    }

    @Subscribe
    public void task2(final String event){
        if(log.isInfoEnabled()){
            log.info("Received event[{}] and will take action by task2()",event);
        }
    }

    @Subscribe
    public void task3(Integer event){
        if(log.isInfoEnabled()){
            log.info("Received event[{}] and will take action by task3()",event);
        }
    }


}
