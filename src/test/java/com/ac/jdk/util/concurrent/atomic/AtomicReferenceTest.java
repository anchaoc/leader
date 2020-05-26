package com.ac.jdk.util.concurrent.atomic;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @author anchao
 * @description
 * @date 2020/4/12 19:38
 **/
public class AtomicReferenceTest {

    @Test
    public void atomicReferenceTest(){
        User user = new User(1L, "安超");
        AtomicReference<User> atomicReference = new AtomicReference<>(user);
        boolean b = atomicReference.compareAndSet(user, new User(2L, "李洋"));
        System.out.println(b);
        System.out.println(atomicReference.get());
    }

    @Data
    @AllArgsConstructor
    class User{
        private Long id;
        private String name;
    }
}
