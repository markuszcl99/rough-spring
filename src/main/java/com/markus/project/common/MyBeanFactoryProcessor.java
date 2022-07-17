package com.markus.project.common;

import com.markus.springframework.beans.BeansException;
import com.markus.springframework.beans.factory.PropertyValue;
import com.markus.springframework.beans.factory.PropertyValues;
import com.markus.springframework.beans.factory.config.BeanDefinition;
import com.markus.springframework.beans.factory.config.BeanFactoryPostProcessor;
import com.markus.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author: markus
 * @date: 2022/7/17 8:22 PM
 * @Description: beanFactory后置处理测试
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class MyBeanFactoryProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition userServiceBeanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = userServiceBeanDefinition.getPropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("company","改为：北京三快"));
    }
}
