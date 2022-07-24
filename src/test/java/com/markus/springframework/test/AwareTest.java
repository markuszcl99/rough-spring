package com.markus.springframework.test;

import com.markus.project.service.UserService;
import com.markus.springframework.beans.factory.BeanFactory;
import com.markus.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @author: markus
 * @date: 2022/7/24 4:58 PM
 * @Description: Aware单元测试类
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class AwareTest {
    @Test
    public void test_xml() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:META-INF/applicationContext.xml");
        applicationContext.registerShutdownHook();

        UserService userService = (UserService) applicationContext.getBean("userService");
        System.out.println("beanName equal result is " + userService.getBeanName().equals("userService"));
        System.out.println("beanFactory result is " + userService.getBeanFactory());
        System.out.println("beanClassLoader is " + userService.getBeanClassLoader());
        System.out.println("applicationContext equal result is " + (userService.getApplicationContext() == applicationContext));
    }
}
