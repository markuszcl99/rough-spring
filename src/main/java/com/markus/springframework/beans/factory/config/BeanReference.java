package com.markus.springframework.beans.factory.config;/**
* @author: markus
* @date: 2022/7/14 11:44 下午
* @Description: Bean的引用
* @Blog: http://markuszhang.com/doc-blog/
* It's my honor to share what I've learned with you!
*/
public class BeanReference {
    private final String beanName;

    public BeanReference(String beanName){
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }
}
