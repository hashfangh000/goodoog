package com.example.goodoog.pattern.proxy.cglib_proxy;

public class Client {
    public static void main(String[] args) {
        ProxyFactory factory = new ProxyFactory();
        // 获取代理对象
        TrainStation proxyObject = factory.getProxyObject();
        // 调用代理对象中sell方法
        proxyObject.sell();

    }
}
