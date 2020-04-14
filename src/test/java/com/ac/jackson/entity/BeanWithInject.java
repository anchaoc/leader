package com.ac.jackson.entity;

import com.fasterxml.jackson.annotation.JacksonInject;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author anchao
 * @date 2020/4/14 13:51
 **/
@Data
public class BeanWithInject {
    /**
     * 反序列化时
     * 通过Inject注入参数
     */
    @JacksonInject
    public BigDecimal price;
    public String name;
}

