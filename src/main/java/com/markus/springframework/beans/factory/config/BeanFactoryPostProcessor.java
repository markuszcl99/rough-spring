package com.markus.springframework.beans.factory.config;

import com.markus.springframework.beans.BeansException;

/**
 * @author: markus
 * @date: 2022/7/17 5:45 PM
 * @Description: BeanFactory后置处理器-Spring框架组建提供的容器扩展机制，允许在Bean对象注册之后未实例化之前，对Bean的定义信息BeanDefinition执行修改操作
 * @Blog: http://markuszhang.com/doc-blog
 * It's my honor to share what I've learned with you!
 */
public interface BeanFactoryPostProcessor {
    /**
     * 在所有的BeanDefinition加载完成后。实例化Bean对象之前，提供用户修改BeanDefinition属性的机制
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
