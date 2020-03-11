package com.ac.guava.eventbus.service;

import com.ac.guava.eventbus.events.Request;
import com.ac.guava.eventbus.events.Response;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;

/**
 * @author anchao
 * @date 2020/3/11 14:32
 */
@Slf4j
public class RequestQueryHandler {
    private final EventBus eventBus;

    public RequestQueryHandler(EventBus eventBus) {
        this.eventBus = eventBus;
        this.eventBus.register(this);
    }



    @Subscribe
    public void doQuery(Request request){
        log.info("start query the query orderNO[{}]",request.getOrderNo());
        Response response = new Response();
        this.eventBus.post(response);
    }



}
