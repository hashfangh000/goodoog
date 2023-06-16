package com.example.goodoog.beans.factory.support;


/**
 * 用来解析配置文件的，该接口只定义了规范 具体由子类实现
 */
public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    void loadBeanDefinitions(String configLocation) throws Exception;
}
