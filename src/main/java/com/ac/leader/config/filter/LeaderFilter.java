package com.ac.leader.config.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.FilterConfig;
import java.io.IOException;

/**
 * @author anchao
 * @date 2020/4/15 14:41
 **/
@Slf4j
@Component
public class LeaderFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("-->LeaderFilter init .");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        log.info("-->LeaderFilter doFilter .");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        log.info("-->LeaderFilter destroy .");
    }
}
