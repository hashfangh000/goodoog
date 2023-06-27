package com.example.goodoog.pattern.visitor;


/**
 * 具体元素角色类 宠物猫
 */
public class Cat implements Animal{


    // 给宠物猫喂食
    @Override
    public void accept(Person person) {
        person.feed(this);
    }
}
