package com.ac.guava.eventbus.listeners;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;

/** 异常事件监听
 * @author anchao
 * @date 2020/3/11 12:11
 */
@Slf4j
public class ExceptionListener {


    @Subscribe
    public void m1(String event){
        if(log.isInfoEnabled()){
            log.info("---->m1 [{}]",event);
        }
    }

    @Subscribe
    public void m2(String event){
        if(log.isInfoEnabled()){
            log.info("---->m2 [{}]",event);
        }
    }

    @Subscribe
    public void m3(String event){
        if(log.isInfoEnabled()){
            log.info("---->m3 [{}]",event);
            //throw new RuntimeException("m3");
            int digital = 1/0;
        }
    }


}
