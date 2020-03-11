package com.ac.guava.eventbus.listeners;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;

/** 事件监听 继承关系
 * @author anchao
 * @date 2020/3/11 11:49
 */
@Slf4j
public abstract class AbstractListener {

    @Subscribe
    public void commonTask(String event){
        if(log.isInfoEnabled()){
            log.info("The event[{}] action by commonTask()",event);
        }
    }


}
