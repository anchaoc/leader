package com.ac;

import com.ac.common.util.LogUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author anchao
 * @date 2020/3/4 13:46
 */
@SpringBootApplication
public class LeaderApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(LeaderApplication.class, args);
        Object getPerson = run.getBean("getPerson");
        LogUtil.printLog(getPerson.toString());
    }

}
