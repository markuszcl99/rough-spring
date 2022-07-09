package com.markus.springframework.beans.factory.support;

import com.markus.springframework.beans.factory.config.BeanDefinition;

/**
 * @author: markus
 * @date: 2022/7/9 5:00 下午
 * @Description: BeanDefinition注册接口
 * @Blog: http://markuszhang.com/doc-blog
 * It's my honor to share what I've learned with you!
 */
public interface BeanDefinitionRegistry {
    /**
     * 向注册表中注册 BeanDefinition
     *
     * @param beanName
     * @param beanDefinition
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
