package com.example.goodoog.pattern.observer;

/**
 * 具体观察者角色类
 */
public class WeiXinUser implements Observer{
    private String name;

    public WeiXinUser(String name) {
        this.name = name;
    }

    @Override
    public void update(String msg) {
        System.out.println(name + "-" + msg);
    }
}
