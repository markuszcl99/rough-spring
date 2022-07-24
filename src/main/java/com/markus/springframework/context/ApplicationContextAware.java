package com.markus.springframework.context;

import com.markus.springframework.beans.BeansException;
import com.markus.springframework.beans.factory.Aware;

/**
 * @author: markus
 * @date: 2022/7/24 4:31 PM
 * @Description: 应用上下文感知接口
 * @Blog: http://markuszhang.com/doc-blog
 * It's my honor to share what I've learned with you!
 */
public interface ApplicationContextAware extends Aware {
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
