package com.markus.springframework.context.support;

import com.markus.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.markus.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author: markus
 * @date: 2022/7/17 5:52 PM
 * @Description: 抽象xml应用上下文-实现加载BeanDefinition方法
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (null != configLocations) {
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }
    }

    protected abstract String[] getConfigLocations();
}
