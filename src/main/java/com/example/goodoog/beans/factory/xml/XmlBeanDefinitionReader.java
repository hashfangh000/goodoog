package com.example.goodoog.beans.factory.xml;

import com.example.goodoog.beans.BeanDefinition;
import com.example.goodoog.beans.MutablePropertyValues;
import com.example.goodoog.beans.PropertyValue;
import com.example.goodoog.beans.factory.support.BeanDefinitionReader;
import com.example.goodoog.beans.factory.support.BeanDefinitionRegistry;
import com.example.goodoog.beans.factory.support.SimpleBeanDefinitionRegistry;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

/**
 * 针对xml配置文件解析的类
 */
public class XmlBeanDefinitionReader implements BeanDefinitionReader {
    // 声明注册表对象
    private BeanDefinitionRegistry registry;

    public XmlBeanDefinitionReader() {
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        registry = new SimpleBeanDefinitionRegistry();
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return registry;
    }

    @Override
    public void loadBeanDefinitions(String configLocation) throws Exception {
        // dom4j进行xml配置文件解析
        SAXReader reader = new SAXReader();
        // 获取类路径下的配置文件
        InputStream is = XmlBeanDefinitionReader.class.getClassLoader().getResourceAsStream(configLocation);
        Document document = reader.read(is);
        // 根据document对象获取根标签对象(beans)
        Element rootElement = document.getRootElement();
        // 获取根表签下的所有的bean标签
        List<Element> beanElements = rootElement.elements("bean");
        // 遍历集合
        for (Element beanElement : beanElements) {
            // 获取id属性
            String id = beanElement.attributeValue("id");
            // 获取class属性
            String className = beanElement.attributeValue("class");
            // 将id属性class属性封装到BeanDefinition对象中
            // 1.创建BeanDefinition
            BeanDefinition beanDefinition = new BeanDefinition();
            beanDefinition.setId(id);
            beanDefinition.setClassName(className);

            // 创建MutablePropertyValues对象
            MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
            // 获取bean标签下所有的property对象
            List<Element> propertyElements = beanElement.elements("property");
            for (Element propertyElement : propertyElements) {
                String name = propertyElement.attributeValue("name");
                String ref = propertyElement.attributeValue("ref");
                String value = propertyElement.attributeValue("property");
                PropertyValue propertyValue = new PropertyValue(name, ref, value);
                mutablePropertyValues.addPropertyValue(propertyValue);
            }
            // 将mutablePropertyValues封装到beanDefinition对象中
            beanDefinition.setPropertyValues(mutablePropertyValues);

            // 将beanDefinition 对象注册到注册表中
            registry.registyBeanDefinition(id, beanDefinition);
        }
    }
}
