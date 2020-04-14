package com.ac.jackson.entity;

import com.fasterxml.jackson.annotation.JsonUnwrapped;
import lombok.AllArgsConstructor;

/**
 * @author anchao
 * @date 2020/4/14 14:41
 **/
@AllArgsConstructor
public class UnwrappedUser {
    public int id;

    /**
     * 该注解指定值在序列化和反序列化时, 去除对应属性的外包装(根节点)
     */
    @JsonUnwrapped
    public Name name;

    @AllArgsConstructor
    public static class Name {
        public String firstName;
        public String lastName;
    }
}
