package com.example.goodoog.pattern.facade;

public class Client {
    public static void main(String[] args) {
        // 创建只能音响对象
        SmartAppliancesFacade facade = new SmartAppliancesFacade();
        // 控制家电
        facade.say("打开家电～");
        System.out.println("==================");
        facade.say("关闭家电～");
    }
}
