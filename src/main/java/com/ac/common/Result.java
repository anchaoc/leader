package com.ac.common;

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


    public  static <T> Result<T> fail(String msg, Integer code){
        Result<T> objectResult = new Result<>();
        objectResult.setCode(code);
        objectResult.setMsg(msg);
        objectResult.setSuccess(false);
        return objectResult;
    }



}
