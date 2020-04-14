package com.ac.jackson.entity;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

/**
 * @author anchao
 * @date 2020/4/14 13:57
 **/
@ToString
@Setter
@Getter
public class ExtendableBean {
    public String name;
    private Map<String, String> properties = new HashMap<>();

    /**
     *把一个可变的map属性作为标准属性,
     *  在反序列过程中, 从Json字符串得到的属性值会加入到map属性中
     */
    @JsonAnySetter
    public void add(String key, String value) {
        properties.put(key, value);
    }
}

