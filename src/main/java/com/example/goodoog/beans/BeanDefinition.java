package com.example.goodoog.beans;

import lombok.Data;

/**
 * 用来封装bean标签数据
 * id 属性
 * class 属性
 * property 自标签数据
 */
@Data
public class BeanDefinition {

    private String id;

    private String className;

    private MutablePropertyValues propertyValues;

    public BeanDefinition() {
        propertyValues = new MutablePropertyValues();
    }
}
