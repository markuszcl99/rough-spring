package com.markus.springframework.test;

import com.markus.project.service.UserService;
import com.markus.springframework.context.support.ClassPathXmlApplicationContext;
import org.junit.Test;

/**
 * @author: markus
 * @date: 2022/7/17 7:55 PM
 * @Description: BeanPostProcessor、BeanFactoryPostProcessor测试
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class PostProcessorTest {
    @Test
    public void test_BeanPostProcessor() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:META-INF/applicationContext.xml");

        UserService userService = (UserService) applicationContext.getBean("userService");
        System.out.println(userService);
    }
}
