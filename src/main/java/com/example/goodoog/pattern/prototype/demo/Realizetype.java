package com.example.goodoog.pattern.prototype.demo;

/**
 * 原型模式
 */
public class Realizetype implements Cloneable{
    public Realizetype() {
        System.out.println("具体原型创建成功～");
    }

    @Override
    public Realizetype clone() throws CloneNotSupportedException {
        System.out.println("具体原型复制成功～");
        return (Realizetype)super.clone();
    }
}
