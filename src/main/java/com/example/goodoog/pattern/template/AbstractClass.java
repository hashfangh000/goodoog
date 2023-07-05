package com.example.goodoog.pattern.template;

/**
 * 抽象类，定义模版方法 和 基本方法
 */
public abstract class AbstractClass {

    // 模版方法定义，在父类定义好模版，不能让子类改变该结构 final
    public final void cookProcess() {
        pourOil();
        heatOil();
        pourVegetable();
        pourSauce();
        fty();
    }

    public void pourOil() {
        System.out.println("倒油～");
    }

    public void heatOil() {
        System.out.println("热油～");
    }


    public abstract void pourVegetable();

    public abstract void pourSauce();

    public void fty() {
        System.out.println("炒菜～");
    }
}
