package com.example.goodoog.pattern.observer;

public class Client {
    public static void main(String[] args) {
        // 创建公众号对象
        SubscriptionSubject subject = new SubscriptionSubject();

        // 订阅公众号
        subject.attach(new WeiXinUser("张三"));
        subject.attach(new WeiXinUser("李四"));
        subject.attach(new WeiXinUser("王五"));

        // 公众号更新推文 发消息给观察者对象
        subject.notify("你好 我更新了～");
    }
}
