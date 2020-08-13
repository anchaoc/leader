package com.ac.designpatterns.structural.bridge;

/**
 * @author anchao
 * @date 2020/8/12 11:02
 **/
public class ABCBank extends Bank {


    public ABCBank(Account account) {
        super(account);
    }

    @Override
    Account openAccount() {
        System.out.println("打开中国农业银行账号");
        account.openAccount();
        return account;
    }


}
