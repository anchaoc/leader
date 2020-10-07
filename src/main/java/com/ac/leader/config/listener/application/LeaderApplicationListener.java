package com.ac.leader.config.listener.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Spring容器监听器
 * @author anchao
 * @date 2020/8/10 15:46
 **/
@Slf4j
@Component
public class LeaderApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.info("监听 Spring容器加载完成触发,可用于初始化环境，准备测试数据、加载一些数据到内存");
        //此处可以开启一个线程，用于查询首页数据，并缓存在内容中，供所有的首页进行查询
        //代码省略
        long timestamp = event.getTimestamp();
        Date date = new Date(timestamp);
        System.out.println(date.toString());
    }
}
