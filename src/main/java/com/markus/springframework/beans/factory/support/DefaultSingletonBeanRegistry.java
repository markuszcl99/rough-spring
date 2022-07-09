package com.markus.springframework.beans.factory.support;

import com.markus.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author: markus
 * @date: 2022/7/9 4:53 下午
 * @Description: 默认的单例Bean注册实现类
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    /**
     * 单例Bean的缓存，bean名称到bean实例的映射
     */
    private Map<String, Object> singletonObjects = new ConcurrentHashMap<>();

    @Override
    public void registerSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName, Object singletonObject) {
        singletonObjects.put(beanName, singletonObject);
    }
}
