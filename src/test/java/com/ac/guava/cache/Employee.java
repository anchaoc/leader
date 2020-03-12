package com.ac.guava.cache;

import lombok.Data;

/**
 * @author anchao
 * @date 2020/3/12 13:44
 */
@Data
public class Employee {

    private String name;
    private String dept;
    private String emId;

    private byte[] data = new byte[1024 * 1024];


    public Employee(String name, String dept, String emId) {
        this.name = name;
        this.dept = dept;
        this.emId = emId;
    }




}
