package com.ac.designpatterns.structural.observer;

/**
 * @author anchao
 * @date 2020/5/29 10:24
 **/
public class Test {
    public static void main(String[] args) {
        WechatMoment wechatMoment = new WechatMoment();
        wechatMoment.setDynamicContent("今天天气不错~");
        Wechat wechat = new Wechat();
        wechat.setName("anchao");
        wechatMoment.addObserver(wechat);
        wechatMoment.sendDynamicContent(wechatMoment);
    }
}
