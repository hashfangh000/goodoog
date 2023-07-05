package com.example.goodoog.pattern.factory.config_factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CoffeeFactory {
    // 1.定义容器对象存储咖啡对象
    private static Map<String, Coffee> map = new HashMap<String, Coffee>();

    // 2.加载配置文件 只需要加载一次，定义static
    static {
        // 2.1 创建properties对象
        Properties p = new Properties();
        // 2.2 调用p对象中的load方法 进行配置文件的加载
        InputStream is = CoffeeFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            p.load(is);
            Set<Object> keys = p.keySet();
            for (Object key : keys) {
                String className = p.getProperty((String)key);
                Class clazz = Class.forName(className);
                Coffee coffee = (Coffee)clazz.newInstance();
                map.put((String)key, coffee);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Coffee createCoffee(String name) {
        return map.get(name);
    }
}
