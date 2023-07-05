package com.example.goodoog.pattern.prototype.demo;

public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Realizetype realizetype = new Realizetype();

        // 调用Realizetype中的方法 进行clone
        Realizetype clone = realizetype.clone();
        System.out.println("原型和克隆：" + (realizetype == clone));  // false
    }
}
