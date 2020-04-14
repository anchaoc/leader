package com.ac.jackson.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreType;
import lombok.AllArgsConstructor;
import lombok.ToString;

/**
 * @author anchao
 * @date 2020/4/14 14:26
 **/
@ToString
@AllArgsConstructor
public class User {
    public int id;
    public Name name;

    /**
     * 该注解标记类型是注解作用的类型的属性都会被忽略
     * 必须作用于类, 标明以该类为类型的属性都会被Jackson忽略
     */
    @JsonIgnoreType
    @AllArgsConstructor
    public static class Name {
        public String firstName;
        public String lastName;
    }
}
