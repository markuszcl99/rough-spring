package com.markus.springframework.context;

import com.markus.springframework.beans.BeansException;

/**
 * @author: markus
 * @date: 2022/7/17 5:50 PM
 * @Description: 可配置的应用上下文
 * @Blog: http://markuszhang.com/doc-blog
 * It's my honor to share what I've learned with you!
 */
public interface ConfigurableApplicationContext extends ApplicationContext{
    /**
     * 刷新容器-spring框架的核心接口
     * @throws BeansException
     */
    void refresh() throws BeansException;
}
