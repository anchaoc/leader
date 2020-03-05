package com.ac.leader.config.jpa;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author anchao
 * @date 2020/3/5 21:05
 */
@Configuration
@EnableJpaRepositories(basePackages="com.ac.leader.dao")
public class JpaConfig {
}
