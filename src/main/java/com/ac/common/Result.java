package com.ac.common;

import com.ac.common.exception.ExceptionEnum;
import lombok.Data;

import java.io.Serializable;

/**
 * @author anchao
 * @date 2020/3/6 14:51
 */
@Data
public class Result<T> implements Serializable {

    private T data;

    private String msg="";

    private Integer code =200;

    private boolean success=true;



    public  static <T> Result<T> success(T t){
        Result<T> objectResult = new Result<>();
        objectResult.setData(t);
        return objectResult;
    }


    public  static <T> Result<T> fail(ExceptionEnum exceptionEnum){
        Result<T> objectResult = new Result<>();
        objectResult.setCode(exceptionEnum.getCode());
        objectResult.setMsg(exceptionEnum.getMsg());
        objectResult.setSuccess(false);
        return objectResult;
    }



}
