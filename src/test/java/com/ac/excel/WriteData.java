package com.ac.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author anchao
 * @date 2020/4/16 16:12
 **/
@Data
@AllArgsConstructor
public class WriteData {

    @ExcelProperty(index = 0)
    private String name;
    @ExcelProperty(index = 1)
    private int age;

}
