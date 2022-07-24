package com.markus.springframework.beans.factory;

/**
 * @author: markus
 * @date: 2022/7/24 4:31 PM
 * @Description: BeanName感知接口
 * @Blog: http://markuszhang.com/doc-blog
 * It's my honor to share what I've learned with you!
 */
public interface BeanNameAware extends Aware{
    void setBeanName(String name);
}
