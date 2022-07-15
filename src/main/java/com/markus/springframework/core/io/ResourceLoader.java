package com.markus.springframework.core.io;

/**
 * @author: markus
 * @date: 2022/7/15 11:02 下午
 * @Description: 资源加载器接口
 * @Blog: http://markuszhang.com/doc-blog
 * It's my honor to share what I've learned with you!
 */
public interface ResourceLoader {
    /**
     * Pseudo URL prefix for loading from the class path: "classpath:"
     */
    String CLASSPATH_URL_PREFIX = "classpath:";

    Resource getResource(String location);
}
