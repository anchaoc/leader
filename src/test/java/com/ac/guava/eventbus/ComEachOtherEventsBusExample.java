package com.ac.guava.eventbus;

import com.ac.guava.eventbus.service.QueryService;
import com.ac.guava.eventbus.service.RequestQueryHandler;
import com.google.common.eventbus.EventBus;

/**
 * @author anchao
 * @date 2020/3/11 14:38
 */
public class ComEachOtherEventsBusExample {

    public static void main(String[] args) {
        EventBus eventBus = new EventBus();

        QueryService queryService = new QueryService(eventBus);

        eventBus.register(new RequestQueryHandler(eventBus));

        queryService.query("NO123456789");

    }
}
