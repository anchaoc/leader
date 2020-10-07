package com.ac.learn.model.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @author anchao
 * @date 2020/4/14 11:04
 **/
@Data
public class LeaderVO {

    @JsonIgnore
    private String name;
}
