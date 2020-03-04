package com.ac.leader.annotation;

import java.lang.annotation.*;

/** 日志打印
 * @author anchao
 * @date 2020/3/4 13:46
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface LogPrint {

    /**
     * 超时时间
     * 单位s
     */
    int timeOut() default 2;
}
