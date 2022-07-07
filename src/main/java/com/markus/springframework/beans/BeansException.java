package com.markus.springframework.beans;

/**
 * @author: markus
 * @date: 2022/7/7 11:15 下午
 * @Description: beans模块全局异常
 * @Blog: http://markuszhang.com/
 * It's my honor to share what I've learned with you!
 */
public class BeansException extends RuntimeException {
    public BeansException(String msg) {
        super(msg);
    }

    public BeansException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
