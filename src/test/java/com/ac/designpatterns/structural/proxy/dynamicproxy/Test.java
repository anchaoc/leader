package com.ac.designpatterns.structural.proxy.dynamicproxy;

import com.ac.designpatterns.structural.proxy.IOrderService;
import com.ac.designpatterns.structural.proxy.Order;
import com.ac.designpatterns.structural.proxy.OrderServiceImpl;

/**
 * 结构型--代理模式--动态代理(jdk)
 * Created by geely
 */
public class Test {
    public static void main(String[] args) {
        Order order = new Order();
        order.setUserId(1);
        IOrderService orderServiceDynamicProxy = (IOrderService) new OrderServiceDynamicProxy(new OrderServiceImpl()).bind();
        orderServiceDynamicProxy.saveOrder(order);
    }
}
