package com.markus.springframework.beans.factory.support;

import com.markus.springframework.beans.BeansException;
import com.markus.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.markus.springframework.beans.factory.config.BeanDefinition;

/**
 * @author: markus
 * @date: 2022/7/7 11:47 下午
 * @Description: 实现Bean实例化的过程
 * @Blog: http://markuszhang.com/
 * It's my honor to share what I've learned with you!
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        addSingleton(beanName, bean);
        return bean;
    }
}
