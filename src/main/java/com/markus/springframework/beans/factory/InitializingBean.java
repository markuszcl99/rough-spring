package com.markus.springframework.beans.factory;

import com.markus.springframework.beans.BeansException;

/**
 * @author: markus
 * @date: 2022/7/24 2:13 PM
 * @Description: 初始化方法 接口
 * @Blog: http://markuszhang.com/doc-blog
 * It's my honor to share what I've learned with you!
 */
public interface InitializingBean {
    /**
     * 此方法在属性填充后进行调用
     * @throws BeansException
     */
    void afterPropertiesSet() throws BeansException;
}
