package com.example.goodoog.pattern.visitor;


/**
 * 具体元素角色类 宠物狗
 */
public class Dog implements Animal{

    private String name;

    @Override
    public void accept(Person person) {
        person.feed(this);
        System.out.println("好好吃， 汪汪汪～");
    }
}
