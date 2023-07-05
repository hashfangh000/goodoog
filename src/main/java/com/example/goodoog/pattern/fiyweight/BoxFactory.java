package com.example.goodoog.pattern.fiyweight;

import java.util.HashMap;

/**
 * 工厂类 将该类设计为单例
 */
public class BoxFactory {

    private HashMap<String, AbstractBox> map;

    public BoxFactory() {
        map = new HashMap<>();
        map.put("I", new IBox());
        map.put("L", new LBox());
        map.put("O", new OBox());
    }

    private static BoxFactory factory = new BoxFactory();

    // 提供一个对象过去工厂对象
    public static BoxFactory getInstance() {
        return factory;
    }

    // 根据名称获取图形对象
    public AbstractBox getShape(String name) {
        return map.get(name);
    }
}
