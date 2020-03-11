package com.ac.guava.eventbus.events;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author anchao
 * @date 2020/3/11 12:00
 */
@Data
@Slf4j
public class Fruit {

    private final String name;

    public Fruit(String name) {
        this.name = name;
    }



}
