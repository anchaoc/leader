package com.ac.guava.eventbus.service;

import com.ac.guava.eventbus.events.Request;
import com.ac.guava.eventbus.events.Response;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;

/**
 * @author anchao
 * @date 2020/3/11 14:20
 */
@Slf4j
public class QueryService {

    private final EventBus eventBus;

    public QueryService(EventBus eventBus) {
        this.eventBus = eventBus;
        this.eventBus.register(this);
    }


    public void query(String orderNo){
        log.info(" the query orderNo[{}]",orderNo);
        this.eventBus.post(new Request(orderNo));
    }


    @Subscribe
    public void handlerResponse(Response response){
        log.info("start query the query response[{}]",response);
    }

}
