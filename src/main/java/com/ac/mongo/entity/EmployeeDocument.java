package com.ac.mongo.entity;

import lombok.Builder;
import lombok.Data;

/**
 * 员工
 * @author anchao
 * @date 2020/3/4 11:49
 */
@Data
@Builder
//@Document("employee")
public class EmployeeDocument {

    /**spring提供主键生成*/
   // @Id
    private String id;

    private String name;

    private Integer age;

}
