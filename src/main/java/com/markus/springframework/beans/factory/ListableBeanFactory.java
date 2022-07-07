package com.markus.springframework.beans.factory;

import com.markus.springframework.beans.BeansException;

import java.util.Map;

/**
 * @author: markus
 * @date: 2022/7/7 11:28 下午
 * @Description: 继承自BeanFactory，拥有BeanFactory的所有功能，并扩展自己的一些方法，例如根据Bean类型获取一批Bean，通过map容器存储；返回容器中BeanDefinition名称的字符串数组等等
 * @Blog: http://markuszhang.com/doc-blog
 * It's my honor to share what I've learned with you!
 */
public interface ListableBeanFactory extends BeanFactory{

    <T> Map<String,T> getBeansOfType(Class<T> type) throws BeansException;

    String[] getBeanDefinitionNames();
}
