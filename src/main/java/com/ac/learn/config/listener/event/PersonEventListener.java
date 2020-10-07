package com.ac.learn.config.listener.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author anchao
 * @date 2020/8/10 16:11
 **/
@Component
@Slf4j
public class PersonEventListener implements ApplicationListener<PersonEvent> {
    @Override
    public void onApplicationEvent(PersonEvent event) {
        // 把事件中的信息获取到
        Person person = event.getPerson();
        // 处理事件，实际项目中可以通知别的微服务或者处理其他逻辑等
        log.info("用户名：" + person.getName());
        log.info("城市：" + person.getCity());
    }
}
