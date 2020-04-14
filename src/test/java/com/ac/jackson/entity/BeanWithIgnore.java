package com.ac.jackson.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;

/**
 * @author anchao
 * @date 2020/4/14 14:23
 **/

/** 该注解是一个类级别的注解
 *  标记一个或多个属性被Jackson忽略
 */
//@JsonIgnoreProperties({ "id" })
@AllArgsConstructor
public class BeanWithIgnore {
    @JsonIgnore
    public int id;
    public String name;
}

