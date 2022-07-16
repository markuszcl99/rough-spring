package com.markus.springframework.beans.factory.support;

import com.markus.springframework.beans.BeansException;
import com.markus.springframework.core.io.Resource;
import com.markus.springframework.core.io.ResourceLoader;

/**
 * @author: markus
 * @date: 2022/7/16 9:23 上午
 * @Description: BeanDefinition 读取功能 接口
 * @Blog: http://markuszhang.com/doc-blog
 * It's my honor to share what I've learned with you!
 */
public interface BeanDefinitionReader {
    /**
     * 获取注册表
     * @return
     */
    BeanDefinitionRegistry getRegistry();

    /**
     * 获取资源加载器
     * @return
     */
    ResourceLoader getResourceLoader();

    /**
     * 加载BeanDefinition
     * @param resource
     * @throws BeansException
     */
    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;
}
