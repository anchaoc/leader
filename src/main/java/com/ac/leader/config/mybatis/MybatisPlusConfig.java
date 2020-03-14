package com.ac.leader.config.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author anchao
 * @date 2020/3/5 21:05
 */
@Configuration
@MapperScan(basePackages={"com.ac.leader.dao"})
public class MybatisPlusConfig {
}
