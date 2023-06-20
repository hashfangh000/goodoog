package com.example.goodoog.context.support;

import com.example.goodoog.beans.factory.support.BeanDefinitionReader;
import com.example.goodoog.beans.factory.support.BeanDefinitionRegistry;
import com.example.goodoog.context.ApplicationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * ApplicationContext接口的子实现类，用于立即加载
 */
public abstract class AbstractApplicationContext implements ApplicationContext {

    // 声明解析器变量
    protected BeanDefinitionReader beanDefinitionReader;

    // 定义用于存储bean对象的map容器
    protected Map<String, Object> singletonObjects = new HashMap<String, Object>();

    // 声明配置文件路径
    protected String configLocation;

    @Override
    public void refresh() throws Exception {
        // 加载beanDefinition对象
        beanDefinitionReader.loadBeanDefinitions(configLocation);
        // 初始化bean
    }

    // bean 初始化
    private void finishBeanInitialization() throws Exception {
        // 获取注册表对象
        BeanDefinitionRegistry registry = beanDefinitionReader.getRegistry();
        // 获取beanDefinition 对象
        String[] beanNames = registry.getBeanDefinition();
        // 进行bean的初始化
        for (String beanName : beanNames) {
            getBean(beanName);
        }
    }
}
