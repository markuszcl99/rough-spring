package com.markus.springframework.beans.factory;

import com.markus.springframework.beans.BeansException;

/**
 * @author: markus
 * @date: 2022/7/24 2:15 PM
 * @Description: 销毁方法 接口
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public interface DisposableBean {
    void destroy() throws BeansException;
}
