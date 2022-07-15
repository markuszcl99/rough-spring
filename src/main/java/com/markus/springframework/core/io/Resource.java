package com.markus.springframework.core.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author: markus
 * @date: 2022/7/15 10:33 下午
 * @Description: 资源接口
 * @Blog: http://markuszhang.com/doc-blog
 * It's my honor to share what I've learned with you!
 */
public interface Resource {
    InputStream getInputStream() throws IOException;
}
