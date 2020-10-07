package com.ac.learn.junit;

import lombok.Data;
import org.junit.Test;
import org.springframework.lang.NonNull;

/** spring NonNull 文档型检查注解
 * @author anchao
 * @description 空值测试
 * @date 2020/4/12 16:43
 **/
public class NonNullTest extends BaseTest{

    @Test
    public void nullTest(){
        UserInterface userInterface = new NonNullTest.UserImpl();
        User user = userInterface.getById(null);
        System.out.println(user);
    }



    interface UserInterface{

        User getById(@NonNull Long id);

    }

    static class UserImpl implements UserInterface{
        @Override
        public User getById(Long id) {
            return null;
        }
    }



    @Data
    static class User{
        private Long id;
        private String name;
        private double price;
    }
}
