package com.markus.springframework.test;

import cn.hutool.core.io.IoUtil;
import com.markus.springframework.core.io.DefaultResourceLoader;
import com.markus.springframework.core.io.Resource;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author: markus
 * @date: 2022/7/16 10:41 上午
 * @Description: 测试Resource实现类是否正常
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class ResourceApiTest {
    private DefaultResourceLoader resourceLoader;

    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test_classpath() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:META-INF/important.properties");
        InputStream is = resource.getInputStream();
        String content = IoUtil.readUtf8(is);
        System.out.println(content);
    }

    @Test
    public void test_file() throws IOException {
        Resource resource = resourceLoader.getResource("src/main/resources/META-INF/important.properties");
        InputStream is = resource.getInputStream();
        String content = IoUtil.readUtf8(is);
        System.out.println(content);
    }

    @Test
    public void test_url() throws IOException {
        Resource resource = resourceLoader.getResource("https://github.com/markuszcl99/rough-spring/blob/main/src/main/resources/META-INF/important.properties");
        InputStream is = resource.getInputStream();
        String content = IoUtil.readUtf8(is);
        System.out.println(content);
    }
}
