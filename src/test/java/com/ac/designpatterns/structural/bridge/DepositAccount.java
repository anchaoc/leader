package com.ac.designpatterns.structural.bridge;

/**
 * @author anchao
 * @date 2020/8/12 10:56
 **/
public class DepositAccount implements Account {
    @Override
    public Account openAccount() {
        System.out.println("打开定期账号");
        return new DepositAccount();
    }

    @Override
    public void showAccountType() {
        System.out.println("这是一个定期账号");
    }
}
