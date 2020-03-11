package com.ac.guava.eventbus.listeners;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;

/** 事件监听
 * @author anchao
 * @date 2020/3/11 11:30
 */
@Slf4j
public class SimpleListener {

    /**
     * 默认按照方法名称 ASCII值倒序执行
     *
     */



    @Subscribe
    public void a(final String event){
        if(log.isInfoEnabled()){
            log.info("Received event[{}] and will take action by DoActiona()",event);
        }
    }



    @Subscribe
    public void b(final String event){
        if(log.isInfoEnabled()){
            log.info("Received event[{}] and will take action by DoActionb()",event);
        }
    }








}
