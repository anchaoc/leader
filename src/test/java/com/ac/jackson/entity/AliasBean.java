package com.ac.jackson.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Setter;
import lombok.ToString;

/**
 * @author anchao
 * @date 2020/4/14 14:14
 **/
@Setter
@ToString
public class AliasBean {
    /**
     * 在反序列化过程中为属性定义一个或多个别名
     */
    @JsonProperty("fName")
    //@JsonAlias({ "fName", "f_name" })使用无效 且会抛异常
    private String fname;
    private String lastName;
}

