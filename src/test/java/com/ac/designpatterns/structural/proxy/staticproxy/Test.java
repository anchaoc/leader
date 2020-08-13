package com.ac.designpatterns.structural.proxy.staticproxy;


import com.ac.designpatterns.structural.proxy.Order;

/**
 * 结构型--代理模式--静态代理(手写类)
 * Created by geely
 */
public class Test {
    public static void main(String[] args) {
        Order order = new Order();
        order.setUserId(2);

        OrderServiceStaticProxy orderServiceStaticProxy = new OrderServiceStaticProxy();
        orderServiceStaticProxy.saveOrder(order);
    }
}
