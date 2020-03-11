package com.ac.guava.eventbus.listeners;

import com.ac.guava.eventbus.events.Apple;
import com.ac.guava.eventbus.events.Fruit;
import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * @author anchao
 * @date 2020/3/11 12:02
 */
@Slf4j
public class FruitEaterListener {

    @Subscribe
    public void eatFruit(final Fruit event){
        if(log.isInfoEnabled()){
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.info("Fruit eat event[{}] action by eatFruit()",event);
        }
    }

    @Subscribe
    public void eatApple(final Apple event){
        if(log.isInfoEnabled()){
            log.info("Fruit eat event[{}] action by eatApple()",event);
        }
    }
}
