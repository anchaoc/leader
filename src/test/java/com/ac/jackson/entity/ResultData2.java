package com.ac.jackson.entity;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author anchao
 * @date 2020/4/14 12:25
 **/
@ToString
@Getter
@Setter
//来指定root wrapper的名称
@JsonRootName(value = "result")
public class ResultData2 {
    private Long id;
    private String name;

    /**
     * 只用被注解的方法序列化整个实体对象
     */
    @JsonValue
    public String concatName(){
        this.name ="b";
        return this.name.concat(";");
    }
}
