package com.ac.leader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class LeaderApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeaderApplication.class, args);
    }

}
