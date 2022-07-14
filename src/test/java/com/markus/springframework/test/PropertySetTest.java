package com.markus.springframework.test;

import com.markus.project.repository.UserDao;
import com.markus.project.service.UserService;
import com.markus.springframework.beans.factory.PropertyValue;
import com.markus.springframework.beans.factory.PropertyValues;
import com.markus.springframework.beans.factory.config.BeanDefinition;
import com.markus.springframework.beans.factory.config.BeanReference;
import com.markus.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.junit.Test;

/**
 * @author: markus
 * @date: 2022/7/14 11:53 下午
 * @Description: 属性填充流程测试
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class PropertySetTest {
    @Test
    public void test_applyPropertyValues() {
        // 1. 初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. UserDao 注册
        BeanDefinition userDaoBeanDefinition = new BeanDefinition(UserDao.class);
        beanFactory.registerBeanDefinition("userDao", userDaoBeanDefinition);

        // 3. UserService 设置属性[userId,userDao]
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("name", "10001"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        // 4. userService 注入bean
        BeanDefinition userBeanDefinition = new BeanDefinition(UserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", userBeanDefinition);

        // 5. 依赖查找
        UserService userService = (UserService) beanFactory.getBean("userService");
        userService.queryUserInfo();

    }
}
