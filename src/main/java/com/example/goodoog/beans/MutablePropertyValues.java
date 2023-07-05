package com.example.goodoog.beans;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 用户存储和管理多个PropertyValue对象
 */
public class MutablePropertyValues implements Iterable<PropertyValue> {

    // 定义list集合对象，用来存储PropertyValue对象
    private final List<PropertyValue> propertyValueList;

    public MutablePropertyValues() {
        this.propertyValueList = new ArrayList<PropertyValue>();
    }

    public MutablePropertyValues(List<PropertyValue> propertyValueList) {
        if (propertyValueList == null) {
            this.propertyValueList = new ArrayList<PropertyValue>();
        } else {
            this.propertyValueList = propertyValueList;
        }
    }

    // 获取所有的PropertyValue对象，以数组形式返回
    public PropertyValue[] getPropertyValues() {
        // 将集合转换为数组并返回
        return propertyValueList.toArray(new PropertyValue[0]);
    }

    // 根据name属性值获取 PropertyValue对象
    public PropertyValue getPropertyValue(String name) {
        for (PropertyValue propertyValue : propertyValueList) {
            if (propertyValue.getName().equals(name)) {
                return propertyValue;
            }
        }
        return null;
    }

    // 判断集合是否为空
    public boolean isEmpty() {
        return propertyValueList.isEmpty();
    }

    // 添加PropertyValue对象
    public MutablePropertyValues addPropertyValue(PropertyValue pv) {
        // 判断集合中存储的PropertyValue是否和传递进来的重复，如果重复 进行覆盖
        for (int i = 0; i < propertyValueList.size(); i++) {
            // 获取每一个PropertyValue对象
            PropertyValue currentPv = propertyValueList.get(i);
            if (currentPv.getName().equals(pv.getName())) {
                propertyValueList.set(i, pv);
                return this; //  实现链式编程
            }
        }
        this.propertyValueList.add(pv);
        return this; //  实现链式编程
    }

    // 判断是否有指定name属性值的对象
    public boolean contains(String propertyName) {
        return getPropertyValue(propertyName) != null;
    }


    //获取迭代器对象
    @Override
    public Iterator<PropertyValue> iterator() {
        return propertyValueList.iterator();
    }
}
