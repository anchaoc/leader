package com.ac.guava.eventbus.listeners;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;

/** 事件监听
 * @author anchao
 * @date 2020/3/11 11:40
 */
@Slf4j
public class MultipleEventListenters {

    @Subscribe
    public void task1(final String event){
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
