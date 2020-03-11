package com.ac.guava.eventbus.events;

import lombok.Data;

/**
 * @author anchao
 * @date 2020/3/11 14:19
 */
@Data
public class Request {

    private String orderNo;


    public Request(String orderNo) {
        this.orderNo = orderNo;
    }




}
