package com.ac.leader.monitor;

import java.lang.annotation.*;

/** 日志打印
 * @author anchao
 * @date 2020/3/4 13:46
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface LogPrint {

    /**
     * 超时时间
     * 单位s
     */
    int timeOut() default 2;

    /**
     * 日志打印中的key，一般可不填，默认方法全路径
     */
    String key() default "";

    /**
     * 进入方法时是否打印输入参数，默认不打印
     */
    boolean printInput() default false;

    /**
     * 方法执行完是否打印结果，默认不打印
     */
    boolean printOutput() default false;

    /**
     * 是否打印方法耗时，默认打印
     */
    boolean printTimeCost() default true;

}
