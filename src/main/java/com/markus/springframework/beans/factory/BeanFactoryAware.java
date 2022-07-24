package com.markus.springframework.beans.factory;

import com.markus.springframework.beans.BeansException;

/**
 * @author: markus
 * @date: 2022/7/24 4:27 PM
 * @Description: 容器感知接口，即实现该接口就能感知所属的BeanFactory
 * @Blog: http://markuszhang.com/doc-blog
 * It's my honor to share what I've learned with you!
 */
public interface BeanFactoryAware extends Aware {
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
