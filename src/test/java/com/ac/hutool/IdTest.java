package com.ac.hutool;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;

/**
 * @author anchao
 * @date 2020/5/12 15:27
 **/
public class IdTest {

    public static void main(String[] args) {
        //参数1为终端ID
        //参数2为数据中心ID
        Snowflake snowflake = IdUtil.createSnowflake(1, 1);
        long id = snowflake.nextId();
        System.out.println(id);
    }
}
