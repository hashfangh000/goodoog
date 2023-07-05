package com.example.goodoog.pattern.visitor;


import java.util.ArrayList;
import java.util.List;

/**
 * 对象结构类
 */
public class Home {
    // 集合 存储对象
    private List<Animal> nodeList = new ArrayList<>();

    // 提供添加元素的功能
    public void add(Animal animal) {
        nodeList.add(animal);
    }

    public void action(Person person) {
        // 遍历集合 获取每一个元素, 让访问者访问每一个元素
        for (Animal animal : nodeList) {
            animal.accept(person);
        }
    }
}
