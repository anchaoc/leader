package com.ac.jackson.entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.AllArgsConstructor;

/**
 * @author anchao
 * @date 2020/4/14 14:33
 **/
//该注解可以覆盖属性是否可见的默认语义, 比如对于不可见的private序列化时变成可见的
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@AllArgsConstructor
public class PrivateBean {
    private int id;
    private String name;
}

