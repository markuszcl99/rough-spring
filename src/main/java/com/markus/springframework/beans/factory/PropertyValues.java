package com.markus.springframework.beans.factory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: markus
 * @date: 2022/7/14 11:27 下午
 * @Description: 属性值集合类
 * @Blog: http://markuszhang.com/doc-blog/
 * It's my honor to share what I've learned with you!
 */
public class PropertyValues {
    private final List<PropertyValue> propertyValueList = new ArrayList<>();

    public void addPropertyValue(PropertyValue pv) {
        this.propertyValueList.add(pv);
    }

    public PropertyValue[] getPropertyValues() {
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName) {
        for (PropertyValue pv : this.propertyValueList) {
            if (pv.getName().equals(propertyName)) {
                return pv;
            }
        }
        return null;
    }
}
