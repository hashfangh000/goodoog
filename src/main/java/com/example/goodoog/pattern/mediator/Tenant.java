package com.example.goodoog.pattern.mediator;


/**
 * 具体的同事角色类
 */
public class Tenant extends Person{
    public Tenant(String name, Mediator mediator) {
        super(name, mediator);
    }

    // 和中介联系（沟通）
    public void connect(String msg) {
        mediator.connect(msg, this);
    }

    // 获取信息
    public void getMsg(String msg) {
        System.out.println("租房者" + name + "获取信息是：" + msg);
    }
}
