package com.markus.springframework.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import com.markus.springframework.beans.BeansException;
import com.markus.springframework.beans.factory.DisposableBean;
import com.markus.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;

/**
 * @author: markus
 * @date: 2022/7/24 2:53 PM
 * @Description: 销毁方法适配器-接口+配置
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class DisposableBeanAdapter implements DisposableBean {

    private final Object bean;

    private final String beanName;

    private String destroyMethodName;

    public DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        // 1. 实现接口 DisposableBean
        if (bean instanceof DisposableBean) {
            ((DisposableBean) bean).destroy();
        }

        // 2. 配置信息destroy-method
        //  !(bean instanceof DisposableBean && "destroy".equals(this.destroyMethodName)) 判断是避免对同一对象进行二次销毁
        if (StrUtil.isNotEmpty(destroyMethodName) && !(bean instanceof DisposableBean && "destroy".equals(this.destroyMethodName))) {
            Method destroyMethod = bean.getClass().getMethod(destroyMethodName);
            if (null == destroyMethod) {
                throw new BeansException("Could not find a destroy method named '" + destroyMethodName + "' on bean with name '" + beanName + "'");
            }
            destroyMethod.invoke(bean);
        }
    }
}
