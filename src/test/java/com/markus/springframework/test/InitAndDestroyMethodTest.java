package com.markus.springframework.test;

import com.markus.project.service.UserService;
import com.markus.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @author: markus
 * @date: 2022/7/24 3:29 PM
 * @Description: 初始化+销毁方法单元测试类
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class InitAndDestroyMethodTest {
    @Test
    public void test_xml() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:META-INF/applicationContext.xml");
        applicationContext.registerShutdownHook();

        UserService userService = (UserService) applicationContext.getBean("userService");
        System.out.println(userService);
    }
}
