package com.example.goodoog.pattern.template;

/**
 * 炒包菜类
 */
public class ConcreteClass_BaoCai extends AbstractClass{

    @Override
    public void pourVegetable() {
        System.out.println("包菜下锅～");
    }

    @Override
    public void pourSauce() {
        System.out.println("辣椒下锅～");
    }
}
