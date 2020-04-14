package com.ac.jdkresources.lang;

import com.google.common.collect.Lists;
import lombok.Data;
import org.junit.Test;

import java.util.LinkedList;

/**
 * @author anchao
 * @date 2020/4/14 15:43
 **/
public class CloneTest {
    @Test
    public void test() {
        LinkedList<User> linkedList = Lists.newLinkedList();
        User user = new User();
        user.setName("ac");
        user.setYear(20);
        linkedList.add(user);
        for (int i = 1; i <= 10; i++) {
            User userClone = ((User) user.clone());
            userClone.setYear(i);
            linkedList.add(userClone);
        }
        System.out.println(linkedList);
    }
}

@Data
class User implements Cloneable {
    private String name;
    private Integer year;

    @Override
    protected Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return new User();
    }
}
