package com.ac.designpatterns.behavioral.observer;

import lombok.Data;

import java.util.Observable;
import java.util.Observer;

/**
 *  微信
 * @author anchao
 * @date 2020/5/29 10:18
 **/
@Data
public class Wechat implements Observer {
    private String name;

    @Override
    public void update(Observable o, Object arg) {
        WechatMoment wechatMoment = (WechatMoment) o;
        System.out.println("观察到朋友圈新动态:"+wechatMoment.getDynamicContent());
    }
}
