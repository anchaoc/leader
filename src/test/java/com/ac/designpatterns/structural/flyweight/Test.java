package com.ac.designpatterns.structural.flyweight;

/**
 * 享元模式
 * @author anchao
 * @date 2020/5/29 11:19
 **/
public class Test {
    private static  final String[] departments ={"RD","QA","PM","BD"};

    public static void main(String[] args) {
        for (int i = 0; i <10 ; i++) {
            //System.out.println("随机数："+Math.random());
            String department = departments[(int)(Math.random()*departments.length)];
            Manager manager = (Manager) EmployeeFactory.getManager(department);
            manager.report();
        }
    }
}