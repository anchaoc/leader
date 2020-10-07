package com.ac.leader.controller.user;

import com.ac.common.Result;
import com.ac.shiro.token.LeaderToken;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author anchao
 * @date 2020/4/16 10:23
 **/
@Api(tags = "user login api")
@RestController
@RequestMapping("user")
public class LoginController {

    @ApiOperation("用户账号密码登录")
    @GetMapping("account/login")
    public Result list(String userName, String passWord, boolean remberMe){
        LeaderToken leaderToken = new LeaderToken(userName,passWord,remberMe);
        Subject subject = SecurityUtils.getSubject();
        //执行登录,登录异常采用全局异常处理
        subject.login(leaderToken);
        return null;
    }
}
