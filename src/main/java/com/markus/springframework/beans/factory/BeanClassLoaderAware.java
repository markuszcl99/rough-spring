package com.markus.springframework.beans.factory;

/**
 * @author: markus
 * @date: 2022/7/24 4:29 PM
 * @Description: Bean类加载器感知接口-实现此接口，便能感知到所属的ClassLoader
 * @Blog: http://markuszhang.com/doc-blog
 * It's my honor to share what I've learned with you!
 */
public interface BeanClassLoaderAware extends Aware {
    void setBeanClassLoader(ClassLoader classLoader);
}
