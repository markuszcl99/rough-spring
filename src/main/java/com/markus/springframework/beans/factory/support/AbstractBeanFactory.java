package com.markus.springframework.beans.factory.support;

import com.markus.springframework.beans.BeansException;
import com.markus.springframework.beans.factory.config.BeanDefinition;
import com.markus.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * @author: markus
 * @date: 2022/7/9 4:44 下午
 * @Description: BeanFactory实现的抽象基类
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements ConfigurableBeanFactory {
    @Override
    public Object getBean(String name) throws BeansException {
        // 先去单例容器中查找相应名称的单例bean
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }

        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }


    /*模板方法，子类实现*/
    protected abstract BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /*模板方法，子类实现*/
    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition) throws BeansException;

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return null;
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return null;
    }
}
