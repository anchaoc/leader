package com.ac.guava.eventbus.listeners;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;

/**
 * @author anchao
 * @date 2020/3/11 11:51
 */
@Slf4j
public class BaseListener extends AbstractListener {

    @Subscribe
    public void baseTask(String event){
        if(log.isInfoEnabled()){
            log.info("The event[{}] action by baseTask()",event);
        }
    }


}
