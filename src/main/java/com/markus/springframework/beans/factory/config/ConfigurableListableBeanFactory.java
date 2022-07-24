package com.markus.springframework.beans.factory.config;

import com.markus.springframework.beans.factory.ListableBeanFactory;

/**
 * @author: markus
 * @date: 2022/7/7 11:42 下午
 * @Description:
 * @Blog: http://markuszhang.com/
 * It's my honor to share what I've learned with you!
 */
public interface ConfigurableListableBeanFactory extends ListableBeanFactory, ConfigurableBeanFactory {

    /**
     * 根据Bean名称获取对应BeanDefinition
     * @param beanName
     * @return
     */
    BeanDefinition getBeanDefinition(String beanName);

    /**
     * 提前初始化所有单例Bean对象
     */
    void preInstantiateSingletons();

    void destroySingletons();
}
