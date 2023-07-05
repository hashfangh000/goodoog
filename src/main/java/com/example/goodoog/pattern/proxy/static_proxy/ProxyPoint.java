package com.example.goodoog.pattern.proxy.static_proxy;

public class ProxyPoint implements SellTickets{

    // 声明火车站类对象
    private TrainStation trainStation = new TrainStation();

    public void sell() {
        System.out.println("代售点收取服务费～");
        trainStation.sell();
    }
}
