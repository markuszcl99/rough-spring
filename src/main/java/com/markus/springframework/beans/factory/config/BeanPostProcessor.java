package com.markus.springframework.beans.factory.config;

import com.markus.springframework.beans.BeansException;

/**
 * @author: markus
 * @date: 2022/7/17 5:47 PM
 * @Description: Bean后置处理器-Spring框架提供的一种扩展机制，它是在bean对象实例化之后修改Bean对象，也可以替换Bean对象。这部分内容与AOP有着密切的关系
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public interface BeanPostProcessor {
    /**
     * 在Bean 对象执行初始化方法之前，执行此方法
     *
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException;

    /**
     * 在Bean 对象执行初始化方法之后，执行此方法
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException;
}
