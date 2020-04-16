package com.ac.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author anchao
 * @date 2020/4/16 10:32
 **/
@AllArgsConstructor
@Getter
public enum ExceptionEnum {

    /**
     * 接口返回状态码
     */
    ERROR_500("服务器异常",500),
    SUCCESS_200("服务器正常",200),


    ERROR_3001("参数有误",3001),


    ERROR_4001("账号有误",4001),
    ERROR_4002("账号并发登录!",4002),
    ERROR_4003("账号或者密码错误!", 4003),


    ;

    private String msg;
    private int code;


}
