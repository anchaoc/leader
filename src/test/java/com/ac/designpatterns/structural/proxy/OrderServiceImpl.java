package com.ac.designpatterns.structural.proxy;

/**
 * @author anchao
 * @date 2020/8/13 17:30
 **/
public class OrderServiceImpl implements IOrderService {
    private IOrderDao iOrderDao;


    @Override
    public int saveOrder(Order order) {
        //Spring会注入，这里采用new的方式
        iOrderDao = new OrderDaoImpl();
        System.out.println("Service层调用Dao层添加Order");
        return iOrderDao.insert(order);
    }
}
