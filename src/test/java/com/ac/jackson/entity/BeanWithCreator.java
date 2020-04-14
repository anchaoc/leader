package com.ac.jackson.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.ToString;

/**
 * @author anchao
 * @date 2020/4/14 13:18
 **/
@ToString
public class BeanWithCreator {
    private int id;
    private String name;

    /**
     * 调整反序列化时构造器/构造工厂的行为
     */
    @JsonCreator
    public BeanWithCreator(
            @JsonProperty("id") int id,
            @JsonProperty("theName") String name) {
        this.id = id;
        this.name = name;
    }

}
