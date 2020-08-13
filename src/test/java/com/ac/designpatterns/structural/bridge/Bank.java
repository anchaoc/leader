package com.ac.designpatterns.structural.bridge;

/**
 * @author anchao
 * @date 2020/8/12 10:59
 **/
public abstract class Bank {
    protected Account account;

    public Bank(Account account) {
        this.account = account;
    }

    abstract Account openAccount();
}
