package com.example.goodoog.pattern.fiyweight;

public class Client {
    public static void main(String[] args) {
        // 获取I图形对象
        AbstractBox box1 = BoxFactory.getInstance().getShape("I");
        box1.display("灰色");

        AbstractBox box4 = BoxFactory.getInstance().getShape("I");
        box4.display("黑色");

        AbstractBox box2 = BoxFactory.getInstance().getShape("L");
        box2.display("黄色");

        AbstractBox box3 = BoxFactory.getInstance().getShape("O");
        box3.display("蓝色");

        System.out.println("两次L是否时同一对象：" + (box1 == box4));
    }
}
