package com.ac.common.exception;

import com.ac.common.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author anchao
 * @date 2020/4/16 10:30
 **/
@Slf4j
@RestControllerAdvice
public class BaseException {

    /**
     * 一般运行时异常返回
     */
    @ExceptionHandler(RuntimeException.class)
    public Result baseException(RuntimeException ex){
        log.error("----->",ex);
        return Result.fail(ExceptionEnum.ERROR_500);
    }

    /**
     * Valid校验异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Result validException(MethodArgumentNotValidException ex){
        log.warn("---->",ex);
        List<ObjectError> allErrors = ex.getBindingResult().getAllErrors();
        String exceptionString = allErrors.stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(","));
        return Result.fail(ExceptionEnum.ERROR_3001);
    }
}
