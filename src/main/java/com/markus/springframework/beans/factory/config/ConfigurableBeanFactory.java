package com.markus.springframework.beans.factory.config;

import com.markus.springframework.beans.factory.HierarchicalBeanFactory;

/**
 * @author: markus
 * @date: 2022/7/7 11:41 下午
 * @Description:
 * @Blog: http://markuszhang.com/doc-blog
 * It's my honor to share what I've learned with you!
 */
public interface ConfigurableBeanFactory extends HierarchicalBeanFactory {
    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);
}
