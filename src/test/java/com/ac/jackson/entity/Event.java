package com.ac.jackson.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author anchao
 * @date 2020/4/14 14:11
 **/
@ToString
@AllArgsConstructor
public class Event {
    public String name;

    /**
     * 使用自定义反序列化器(custom deserializer)
     */
//    @JsonDeserialize(using = CustomDateDeserializer.class)
//    public Date eventDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    public Date date;

}

