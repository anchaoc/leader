package com.ac.designpatterns.structural.proxy;

/**
 * @author anchao
 * @date 2020/8/13 17:27
 **/
public class OrderDaoImpl implements IOrderDao {
    @Override
    public int insert(Order order) {
        System.out.println("Dao层添加Order成功");
        return 1;
    }
}
