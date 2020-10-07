package com.ac.spring.config;

import com.ac.common.util.LogUtil;
import com.ac.spring.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author anchao
 * @date 2020/10/7 15:11
 **/
@Configuration
public class BeanConfig {

    @Bean
    @Scope("prototype")
    public Person getPerson(){
        Person person = new Person();
        person.setLastName("安超");
        person.setGender("男");
        person.setAge(26);
        person.setEmail("anchaoc@163.com");
        LogUtil.printLog(String.format("Person:%s 实体bean注册到IOC容器中",person));
        return person;
    }
}
