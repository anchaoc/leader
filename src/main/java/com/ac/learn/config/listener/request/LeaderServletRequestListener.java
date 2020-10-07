package com.ac.learn.config.listener.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpServletRequest;

/**
 * @author anchao
 * @date 2020/8/10 16:06
 **/
@Component
@Slf4j
public class LeaderServletRequestListener implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
        log.info("session id为：{}", request.getRequestedSessionId());
        log.info("request url为：{}", request.getRequestURL());
        request.setAttribute("name", "anchao");
    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        log.info("request end");
        HttpServletRequest request = (HttpServletRequest) servletRequestEvent.getServletRequest();
        log.info("request域中保存的name值为：{}", request.getAttribute("name"));

    }
}
