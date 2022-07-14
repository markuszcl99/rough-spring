package com.markus.springframework.beans.factory;

/**
 * @author: markus
 * @date: 2022/7/14 11:14 下午
 * @Description: 属性值对象
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class PropertyValue {
    private final String name;
    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }
}
