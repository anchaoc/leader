package com.ac.guava.eventbus.listeners;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;

/** 事件监听
 * @author anchao
 * @date 2020/3/11 11:30
 */
@Slf4j
public class SimpleListener {



    @Subscribe
    public void doAction(final String event){
        if(log.isInfoEnabled()){
            log.info("Received event[{}] and will take action by DoAction()",event);
        }
    }





}
