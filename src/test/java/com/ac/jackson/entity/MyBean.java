package com.ac.jackson.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSetter;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author anchao
 * @date 2020/4/14 14:08
 **/
@Data
@AllArgsConstructor
//该注解在序列化时会排除属性值是空值（empty或null）、没有默认值的属性。
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MyBean {
    public int id;
    private String name;

    /** 反序列化
     * 标记一个方法是setter方法
     */
    @JsonSetter("name")
    public void setTheName(String name) {
        this.name = name.concat(":");
    }
}

