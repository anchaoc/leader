package com.ac.designpatterns.creational.prototype;

import lombok.Data;

import java.util.Date;

/**
 * @author anchao
 * @date 2020/5/29 9:51
 **/
@Data
public class Pig implements Cloneable{
    private String name;
    private Date birthday;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Pig pigClone = (Pig)super.clone();
        //深克隆
        pigClone.birthday = (Date) birthday.clone();
        return pigClone;
    }
}
