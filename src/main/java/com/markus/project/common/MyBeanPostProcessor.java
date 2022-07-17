package com.markus.project.common;

import com.markus.project.service.UserService;
import com.markus.springframework.beans.BeansException;
import com.markus.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author: markus
 * @date: 2022/7/17 7:56 PM
 * @Description: 扩展SpringBean
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setCompany("改为：美团");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setLocation("改为：北京");
        }
        return bean;
    }
}
