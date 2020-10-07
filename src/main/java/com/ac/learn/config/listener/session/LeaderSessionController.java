package com.ac.learn.config.listener.session;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author anchao
 * @date 2020/8/10 15:57
 **/
@Controller
@RequestMapping("/")
public class LeaderSessionController {
    @GetMapping("/total")
    @ResponseBody
    public String getTotalUser(HttpServletRequest request) {
        Integer count = (Integer) request.getSession().getServletContext().getAttribute("count");
        return "当前在线人数：" + count;
    }
}
