package com.ac.leader.config.threadpool;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @author anchao
 * @date 2020/4/15 14:37
 **/
@Slf4j
@Configuration
public class ThreadPoolConfig {

    /**
     * 线程池配置
     */
    @Bean(name = "threadPoolTaskExecutor")
    public ThreadPoolTaskExecutor getThreadPoolTaskExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(20);
        executor.setQueueCapacity(10);
        executor.setKeepAliveSeconds(5);
        executor.setThreadNamePrefix("leader-");
        //队列满，线程被拒绝执行策略
        executor.setRejectedExecutionHandler(new java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        log.info("ThreadPoolTaskExecutor init ok-->");
        return executor;
    }

}
