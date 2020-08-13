package com.ac.designpatterns.structural.bridge;

/**
 * @author anchao
 * @date 2020/8/12 10:56
 **/
public class SavingAccount implements Account {
    @Override
    public Account openAccount() {
        System.out.println("打开活期账号");
        return new SavingAccount();
    }

    @Override
    public void showAccountType() {
        System.out.println("这是一个活期账号");
    }
}
