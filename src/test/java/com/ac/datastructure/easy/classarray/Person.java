package com.ac.datastructure.easy.classarray;

/**
 * Person实体
 */
public class Person {
    /**
     * 名
     */
    private String lastName;
    /**
     * 姓
     */
    private String firstName;
    /**
     * 年龄
     */
    private int age    ;

    public Person(String lastName, String firstName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    /**
     * 显示Person属性
     */
    public void dispalyPerson(){
        System.out.println("lastName ="+lastName);
        System.out.println("firstName ="+firstName);
        System.out.println("age ="+age);
    }

    /**
     *
     * 获取名
     * @return
     */
    public String getLastName(){
        return this.lastName;
    }

}
