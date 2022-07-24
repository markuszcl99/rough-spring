package com.markus.springframework.context.support;

import com.markus.springframework.beans.BeansException;
import com.markus.springframework.beans.factory.config.BeanPostProcessor;
import com.markus.springframework.context.ApplicationContext;
import com.markus.springframework.context.ApplicationContextAware;

/**
 * @author: markus
 * @date: 2022/7/24 4:33 PM
 * @Description: 包装处理器
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class ApplicationContextAwareProcessor implements BeanPostProcessor {

    private final ApplicationContext applicationContext;

    public ApplicationContextAwareProcessor(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (bean instanceof ApplicationContextAware) {
            ((ApplicationContextAware) bean).setApplicationContext(applicationContext);
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
