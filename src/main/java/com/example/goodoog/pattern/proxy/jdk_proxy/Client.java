package com.example.goodoog.pattern.proxy.jdk_proxy;

public class Client {
    public static void main(String[] args) {
        // 获取代理对象
        //创建代理工厂对象
        ProxyFactory factory = new ProxyFactory();
        //使用factory获取代理对象
        SellTickets proxyObject = factory.getProxyObject();
        // 调用方法
        proxyObject.sell();
        System.out.println(proxyObject.getClass());


    }
}
