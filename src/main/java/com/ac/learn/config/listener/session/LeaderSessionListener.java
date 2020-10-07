package com.ac.learn.config.listener.session;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author anchao
 * @date 2020/8/10 15:52
 **/
@Slf4j
@Component
public class LeaderSessionListener implements HttpSessionListener {

    /**
     * 记录在线的用户数量
     */
    public static Integer count = 0;

    @Override
    public synchronized void sessionCreated(HttpSessionEvent httpSessionEvent) {
        log.info("新用户上线了");
        count++;
        httpSessionEvent.getSession().getServletContext().setAttribute("count", count);
    }

    @Override
    public synchronized void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        log.info("用户下线了");
        count--;
        httpSessionEvent.getSession().getServletContext().setAttribute("count", count);
    }
}
