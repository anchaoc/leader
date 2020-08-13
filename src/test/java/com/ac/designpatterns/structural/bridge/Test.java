package com.ac.designpatterns.structural.bridge;

/**
 * 结构型--桥接模式
 * @author anchao
 * @date 2020/8/12 10:52
 **/
public class Test {
    public static void main(String[] args) {
        Bank icbcBank = new ICBCBank(new DepositAccount());
        Account icbcAccount = icbcBank.openAccount();
        icbcAccount.showAccountType();

        ABCBank abcBank = new ABCBank(new SavingAccount());
        Account abcAccount = abcBank.openAccount();
        abcAccount.showAccountType();


    }
}
