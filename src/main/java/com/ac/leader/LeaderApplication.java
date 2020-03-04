package com.ac.leader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

/** 日志打印
 * @author anchao
 * @date 2020/3/4 13:46
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class LeaderApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeaderApplication.class, args);
    }

}
