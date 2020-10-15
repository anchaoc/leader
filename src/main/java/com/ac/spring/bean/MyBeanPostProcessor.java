package com.ac.spring.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author anchao
 * @date 2020/10/15 14:30
 **/
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    /**
     * 初始化bean之前
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanPostProcessor before init "+beanName);
        return bean;
    }

    /**
     * 初始化bean之后
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("MyBeanPostProcessor after init"+beanName);
        return bean;
    }
}
