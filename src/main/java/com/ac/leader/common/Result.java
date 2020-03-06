package com.ac.leader.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author anchao
 * @date 2020/3/6 14:51
 */
@Data
public class Result<T> implements Serializable {

    private T data;

    private String msg="成功";

    private Integer code =200;

    private boolean success=true;



    public  Result<T> success(T t){
        Result<T> objectResult = new Result<>();
        objectResult.setData(t);
        return objectResult;
    }


    public  Result<T> exception(String msg,Integer code){
        Result<T> objectResult = new Result<>();
        objectResult.setCode(code);
        objectResult.setMsg(msg);
        objectResult.setSuccess(false);
        return objectResult;
    }



}
