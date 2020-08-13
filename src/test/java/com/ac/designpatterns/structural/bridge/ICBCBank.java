package com.ac.designpatterns.structural.bridge;

/**
 * @author anchao
 * @date 2020/8/12 11:04
 **/
public class ICBCBank extends Bank {
    public ICBCBank(Account account) {
        super(account);
    }

    @Override
    Account openAccount() {
        System.out.println("打开中国工商银行账号");
        account.openAccount();
        return account;
    }
}
