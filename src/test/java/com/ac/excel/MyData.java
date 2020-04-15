package com.ac.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author anchao
 * @date 2020/4/13 18:12
 **/
@Data
@NoArgsConstructor
public class MyData {
    @ExcelProperty(index = 0)
    private String dateTime;
    @ExcelProperty(index = 1)
    private String num;


}
