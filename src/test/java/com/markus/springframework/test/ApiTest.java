package com.markus.springframework.test;

import com.markus.project.service.UserService;
import com.markus.springframework.beans.factory.BeanFactory;
import com.markus.springframework.beans.factory.config.BeanDefinition;
import com.markus.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * @author: markus
 * @date: 2022/7/9 8:34 下午
 * @Description: 单元测试类
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class ApiTest {

    @Test
    public void test_BeanFactory() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 2.默认构造器
        defaultConstructor(beanFactory);
        // 3.有参构造器
        hasParameterConstructor(beanFactory);
    }

    private void hasParameterConstructor(DefaultListableBeanFactory beanFactory) {
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 第一次获取bean
        UserService userService = (UserService) beanFactory.getBean("userService", "有参构造器");
        userService.queryUserInfo();
    }

    private void defaultConstructor(DefaultListableBeanFactory beanFactory) {
        // 注册 bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 第一次获取bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

        // 第二次获取 bean from Singleton
        UserService userService_singleton = (UserService) beanFactory.getBean("userService");
        userService_singleton.queryUserInfo();

        System.out.println("userService == userService_singleton? : " + (userService == userService_singleton));
    }
}
