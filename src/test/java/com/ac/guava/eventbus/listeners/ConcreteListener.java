package com.ac.guava.eventbus.listeners;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;

/**
 * @author anchao
 * @date 2020/3/11 11:52
 */
@Slf4j
public class ConcreteListener extends BaseListener {

    @Subscribe
    public void concrete(String event){
        if(log.isInfoEnabled()){
            log.info("The event[{}] action by concrete()",event);
        }
    }
}
