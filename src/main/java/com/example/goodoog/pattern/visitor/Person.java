package com.example.goodoog.pattern.visitor;

/**
 * 抽象访问者角色类
 */
public interface Person {

    void feed(Cat cat);


    void feed(Dog dog);
}
