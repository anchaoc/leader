package com.ac.jackson.entity;

import com.ac.jackson.serializer.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author anchao
 * @date 2020/4/14 11:23
 **/
@ToString
@Getter
@Setter
public class ResultData3 implements Serializable {

    /**
     * 指定一个自定义序列化器(custom serializer)来序列化实体例的某属性
     */
    @JsonSerialize(using = CustomDateSerializer.class)
    private LocalDateTime time;


}
