package com.markus.springframework.beans.factory;

import com.markus.springframework.beans.BeansException;

/**
 * @author: markus
 * @date: 2022/7/7 10:32 下午
 * @Description: Bean工厂
 * @Blog: http://markuszhang.com/doc-blog
 * It's my honor to share what I've learned with you!
 */
public interface BeanFactory {

    /**
     * 根据bean的名称查找Bean实例
     *
     * @param name bean名称
     * @return 相应Bean的一个实例
     * @throws BeansException
     */
    Object getObject(String name) throws BeansException;

    /**
     * 根据bean的名称以及构造参数查找Bean实例
     * 允许指定显式构造函数参数/工厂方法参数，覆盖 bean 定义中指定的默认参数（如果有）。
     *
     * @param name bean名称
     * @param args 使用显式参数创建 bean 实例时使用的参数（仅在创建新实例而不是检索现有实例时应用）
     * @return 相应Bean的一个实例
     * @throws BeansException
     */
    Object getObject(String name, Object... args) throws BeansException;

    /**
     * 返回指定 bean 的一个实例，该实例可以是共享的，也可以是独立的。
     *
     * @param name 要检索的 bean 的名称
     * @param requiredType bean 必须匹配的类型；可以是接口或超类
     * @param <T>
     * @return bean 的一个实例
     * @throws BeansException
     */
    <T> T getObject(String name, Class<T> requiredType) throws BeansException;

    /**
     * 返回指定 bean 的一个实例，该实例可以是单例的，也可以是原型的。
     * @param requiredType bean 必须匹配的类型；可以是接口或超类
     * @param <T>
     * @return bean 的一个实例
     * @throws BeansException
     */
    <T> T getObject(Class<T> requiredType) throws BeansException;
}
