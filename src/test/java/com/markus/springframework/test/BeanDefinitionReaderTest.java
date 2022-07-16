package com.markus.springframework.test;

import com.markus.project.service.UserService;
import com.markus.springframework.beans.factory.support.BeanDefinitionReader;
import com.markus.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.markus.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.junit.Test;

/**
 * @author: markus
 * @date: 2022/7/16 10:58 上午
 * @Description: BeanDefinitionReader 测试
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class BeanDefinitionReaderTest {
    @Test
    public void test_beanDefinitionReader(){
        // 1. 初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册bean
        BeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
        beanDefinitionReader.loadBeanDefinitions("classpath:META-INF/applicationContext.xml");

        // 3. 依赖查找bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();



    }
}
