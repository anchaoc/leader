package com.ac.common.exception;

import com.ac.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.ConcurrentAccessException;
import org.apache.shiro.authc.CredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author anchao
 * @date 2020/4/16 10:37
 **/
@Slf4j
@RestControllerAdvice
public class LoginException {


    @ExceptionHandler(AccountException.class)
    public Result accountException(AccountException ex){
        log.warn("-->账号有误!",ex);
        return Result.fail(ExceptionEnum.ERROR_4001);
    }


    @ExceptionHandler(ConcurrentAccessException.class)
    public Result concurrentAccessException(ConcurrentAccessException ex){
        log.warn("-->账号并发登录!",ex);
        return Result.fail(ExceptionEnum.ERROR_4002);
    }

    @ExceptionHandler(CredentialsException.class)
    public Result credentialsException(CredentialsException ex){
        log.warn("-->账号或者密码错误!",ex);
        return Result.fail(ExceptionEnum.ERROR_4003);
    }


}
