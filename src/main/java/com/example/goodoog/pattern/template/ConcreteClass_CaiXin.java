package com.example.goodoog.pattern.template;

/**
 * 炒包菜类
 */
public class ConcreteClass_CaiXin extends AbstractClass{

    @Override
    public void pourVegetable() {
        System.out.println("菜心下锅～");
    }

    @Override
    public void pourSauce() {
        System.out.println("蒜泥下锅～");
    }
}
