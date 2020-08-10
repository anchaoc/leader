package com.ac.leader.config.listener.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author anchao
 * @date 2020/8/10 16:13
 **/
@Service
@Slf4j
public class PersonService {

    @Resource
    private ApplicationContext applicationContext;

    /**
     * 发布事件
     * @return
     */
    public Person getPerson() {
        Person person = new Person("安超","北京");
        // 发布事件
        PersonEvent event = new PersonEvent(this, person);
        applicationContext.publishEvent(event);
        log.info("触发器被触发");
        return person;
    }
}
