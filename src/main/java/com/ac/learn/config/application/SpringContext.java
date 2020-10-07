package com.ac.learn.config.application;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/** 获取容器中的bean
 * @author anchao
 * @date 2020/3/12 19:57
 */
@Component
public class SpringContext implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext( ApplicationContext applicationContext) throws BeansException {
        SpringContext.applicationContext = applicationContext;
    }


    public static <T> T  getBean(Class<T> tClass){
        T bean = applicationContext.getBean(tClass);
        return bean;
    }


}
