package com.example.goodoog.beans.factory;

/**
 * IOC 容器 父接口
 */
public interface BeanFactory {
    Object getBean(String name) throws Exception;

    <T> T getBean(String name, Class<? extends T> clazz) throws Exception;
}
