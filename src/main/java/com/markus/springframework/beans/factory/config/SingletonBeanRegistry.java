package com.markus.springframework.beans.factory.config;

/**
 * @author: markus
 * @date: 2022/7/9 4:51 下午
 * @Description: 单例bean注册接口
 * @Blog: http://markuszhang.com/doc-blog
 * It's my honor to share what I've learned with you!
 */
public interface SingletonBeanRegistry {
    /**
     * 单例Bean注册
     *
     * @param beanName        bean的名称
     * @param singletonObject bean实例
     */
    void registerSingleton(String beanName, Object singletonObject);

    /**
     * 获取单例Bean
     *
     * @param beanName
     * @return
     */
    Object getSingleton(String beanName);
}
