package com.ac.designpatterns.structural.observer;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Observable;

/**
 * 朋友圈
 * @author anchao
 * @date 2020/5/29 10:18
 **/
@Data
@EqualsAndHashCode(callSuper = true)
public class WechatMoment extends Observable {
    private String dynamicContent;


    public void sendDynamicContent(WechatMoment wechatMoment){
        System.out.println("朋友圈新增一条动态:"+wechatMoment.dynamicContent);
       super.setChanged();
       super.notifyObservers();
    }
}
