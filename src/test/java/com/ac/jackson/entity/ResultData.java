package com.ac.jackson.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Map;

/**
 * @author anchao
 * @date 2020/4/14 11:23
 **/
@ToString
@Getter
@Setter
/**
 * 指定实体属性序列化后的顺序
 */
@JsonPropertyOrder({ "name", "id"})
public class ResultData implements Serializable {
    private Long id;
    private String name;
    private Map<String,Object> map;
    /**
     * 序列化时把属性的值转json输出
     */
    @JsonRawValue
    public String attrs;

    /**
     * 把可变的Map类型属性当做标准属性。
     */
    @JsonAnyGetter
    public Map<String, Object> getMap() {
        return map;
    }

    /**
     *指定方法是属性name属性的getter方法
     */
    @JsonGetter("name")
    public String concatName(){
        return this.name.concat("_");
    }

}
