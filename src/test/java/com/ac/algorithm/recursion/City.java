package com.ac.algorithm.recursion;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Tolerate;

import java.util.List;

/**
 * @author anchao
 * @date 2020/12/12 22:15
 **/
@Getter
@Setter
@ToString
@Builder
public class City {
    private Integer id;
    private String name;
    private Integer pid;
    private Integer level;
    private List<City> childCity;

    @Tolerate
    public City() {
    }
}
