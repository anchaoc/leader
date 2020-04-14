package com.ac.shiro.filter;

import com.ac.leader.common.Result;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.web.filter.authc.UserFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class MyShiroFilter extends UserFilter {
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if (this.isLoginRequest(request, response)) {
            return true;
        } else {
            log.warn("-->MyShiroFilter,用户存在未登录状态");
            HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
            httpServletResponse.setHeader("Access-Control-Allow-Headers", "Origin,X-Requested-With,Content-Type,Accept,Authorization,X-TOKEN,XMLHttpRequest");
            httpServletResponse.setHeader("Access-Control-Allow-Methods", "*");
            response.setContentType("application/json; charset=utf-8");
            Result<String> result = new Result<String>().success("用户未登录,请登录以后再访问");
            response.getWriter().write(JSON.toJSONString(result));
            //返回false表示不执行后续的过滤器
            return false;
        }
    }



}