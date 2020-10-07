package com.ac.leader.config.listener.event;

/**
 * @author anchao
 * @date 2020/8/10 16:10
 **/
public class Person {
    private String name;
    private String city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public Person(String name, String city) {
        this.name = name;
        this.city = city;
    }
}
