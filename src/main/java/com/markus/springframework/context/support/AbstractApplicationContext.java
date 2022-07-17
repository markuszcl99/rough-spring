package com.markus.springframework.context.support;

import com.markus.springframework.beans.BeansException;
import com.markus.springframework.beans.factory.config.BeanFactoryPostProcessor;
import com.markus.springframework.beans.factory.config.BeanPostProcessor;
import com.markus.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import com.markus.springframework.context.ConfigurableApplicationContext;
import com.markus.springframework.core.io.DefaultResourceLoader;

import java.util.Map;

/**
 * @author: markus
 * @date: 2022/7/17 5:51 PM
 * @Description: Spring应用上下文抽象类
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public abstract class AbstractApplicationContext extends DefaultResourceLoader implements ConfigurableApplicationContext {
    @Override
    public void refresh() throws BeansException {
        // 1. 创建BeanFactory，并加载BeanDefinition
        refreshBeanFactory();

        // 2. 获取BeanFactory
        ConfigurableListableBeanFactory beanFactory = getBeanFactory();

        // 3. 在Bean实例化之前，执行BeanFactoryPostProcessor（调用在上下文中注册为Bean的工厂处理器）
        invokeBeanFactoryPostProcessors(beanFactory);

        // 4. BeanPostProcessor 在Bean实例化之前先执行注册操作
        registerBeanPostProcessor(beanFactory);

        // 5. 提前实例化单例Bean对象
        beanFactory.preInstantiateSingletons();
    }

    private void invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanFactoryPostProcessor> beanFactoryPostProcessorMap = beanFactory.getBeansOfType(BeanFactoryPostProcessor.class);
        for (BeanFactoryPostProcessor beanFactoryPostProcessor : beanFactoryPostProcessorMap.values()) {
            beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);
        }
    }


    private void registerBeanPostProcessor(ConfigurableListableBeanFactory beanFactory) {
        Map<String, BeanPostProcessor> beanPostProcessorMap = beanFactory.getBeansOfType(BeanPostProcessor.class);
        for (BeanPostProcessor beanPostProcessor : beanPostProcessorMap.values()) {
            beanFactory.addBeanPostProcessor(beanPostProcessor);
        }
    }

    protected abstract void refreshBeanFactory() throws BeansException;

    protected abstract ConfigurableListableBeanFactory getBeanFactory() throws BeansException;
}
