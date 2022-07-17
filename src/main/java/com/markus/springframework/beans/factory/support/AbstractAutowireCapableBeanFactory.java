package com.markus.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import com.markus.springframework.beans.BeansException;
import com.markus.springframework.beans.factory.PropertyValue;
import com.markus.springframework.beans.factory.PropertyValues;
import com.markus.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.markus.springframework.beans.factory.config.BeanDefinition;
import com.markus.springframework.beans.factory.config.BeanPostProcessor;
import com.markus.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

/**
 * @author: markus
 * @date: 2022/7/7 11:47 下午
 * @Description: 实现Bean实例化的过程
 * @Blog: http://markuszhang.com/
 * It's my honor to share what I've learned with you!
 */
public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory implements AutowireCapableBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            bean = createBeanInstance(beanDefinition, beanName, args);

            // Bean属性填充
            applyPropertyValues(beanName, bean, beanDefinition);

            // 执行Bean的初始化方法和BeanPostProcessor的前置和后置处理方法以及用户自定义方法init-method
            bean = initializeBean(beanName, bean, beanDefinition);
        } catch (Exception e) {
            throw new BeansException("Instantiation of bean failed", e);
        }
        addSingleton(beanName, bean);
        return bean;
    }

    public InstantiationStrategy setInstantiationStrategy() {
        return instantiationStrategy;
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }


    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        Constructor constructorToUse = null;
        Class<?> beanClass = beanDefinition.getBeanClass();
        // 拿到该Class的构造器数组
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor<?> ctor : declaredConstructors) {
            // 遍历数组找到符合参数长度符合的构造器
            if (null != args && ctor.getParameterTypes().length == args.length) {
                constructorToUse = ctor;
                break;
            }
        }
        // 使用实例化策略对指定构造器进行实例化操作
        return instantiationStrategy.instantiate(beanDefinition, beanName, constructorToUse, args);
    }

    protected void applyPropertyValues(String beanName, Object bean, BeanDefinition beanDefinition) {
        try {
            PropertyValues propertyValues = beanDefinition.getPropertyValues();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                if (value instanceof BeanReference) {
                    BeanReference br = (BeanReference) value;
                    value = getBean(br.getBeanName());
                }
                // 使用hutool-all工具，通过反射将字段设置到实例中
                BeanUtil.setFieldValue(bean, name, value);
            }
        } catch (Exception e) {
            throw new BeansException("Error setting property values: " + beanName);
        }
    }

    private Object initializeBean(String beanName, Object bean, BeanDefinition beanDefinition) {
        //1. 执行BeanPostProcessor Before处理
        Object wrappedBean = applyBeanPostProcessorBeforeInitialization(bean, beanName);

        //2. 调用用户自定义方法
        invokeInitMethod(beanName, bean, beanDefinition);

        //3. 执行BeanPostProcessor After处理
        wrappedBean = applyBeanPostProcessorAfterInitialization(bean, beanName);

        return wrappedBean;
    }

    @Override
    public Object applyBeanPostProcessorBeforeInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for (BeanPostProcessor beanPostProcessor : getBeanPostProcessors()) {
            Object current = beanPostProcessor.postProcessBeforeInitialization(result, beanName);
            if (null == current) return result;
            result = current;
        }
        return result;
    }

    private void invokeInitMethod(String beanName, Object wrappedBean, BeanDefinition beanDefinition) {

    }

    @Override
    public Object applyBeanPostProcessorAfterInitialization(Object existingBean, String beanName) throws BeansException {
        Object result = existingBean;
        for (BeanPostProcessor beanPostProcessor : getBeanPostProcessors()) {
            Object current = beanPostProcessor.postProcessAfterInitialization(result, beanName);
            if (null == current) return result;
            result = current;
        }
        return result;
    }
}
