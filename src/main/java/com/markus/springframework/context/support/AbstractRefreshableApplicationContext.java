package com.markus.springframework.context.support;

import com.markus.springframework.beans.BeansException;
import com.markus.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import com.markus.springframework.beans.factory.support.DefaultListableBeanFactory;

import java.util.Map;

/**
 * @author: markus
 * @date: 2022/7/17 5:52 PM
 * @Description:
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public abstract class AbstractRefreshableApplicationContext extends AbstractApplicationContext {

    private DefaultListableBeanFactory beanFactory;

    /**
     * 提供BeanFactory的实例化以及对资源配置的加载操作
     *
     * @throws BeansException
     */
    @Override
    protected void refreshBeanFactory() throws BeansException {
        DefaultListableBeanFactory beanFactory = createBeanFactory();
        loadBeanDefinitions(beanFactory);
        this.beanFactory = beanFactory;
    }

    private DefaultListableBeanFactory createBeanFactory() {
        return new DefaultListableBeanFactory();
    }

    protected abstract void loadBeanDefinitions(DefaultListableBeanFactory beanFactory);

    @Override
    protected ConfigurableListableBeanFactory getBeanFactory() throws BeansException {
        return beanFactory;
    }

    @Override
    public Object getBean(String name) throws BeansException {
        return this.beanFactory.getBean(name);
    }

    @Override
    public Object getBean(String name, Object... args) throws BeansException {
        return this.beanFactory.getBean(name, args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) throws BeansException {
        return this.beanFactory.getBean(name, requiredType);
    }

    @Override
    public <T> T getBean(Class<T> requiredType) throws BeansException {
        return this.beanFactory.getBean(requiredType);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> type) throws BeansException {
        return this.beanFactory.getBeansOfType(type);
    }

    @Override
    public String[] getBeanDefinitionNames() {
        return this.beanFactory.getBeanDefinitionNames();
    }
}
