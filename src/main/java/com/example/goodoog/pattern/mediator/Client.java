package com.example.goodoog.pattern.mediator;

public class Client {
    public static void main(String[] args) {
        MediatorStructure mediator = new MediatorStructure();

        // 创建租房者对象
        Tenant tenant = new Tenant("李四", mediator);
        // 创建房主对象
        HouseOwner houseOwner = new HouseOwner("张三", mediator);

        // 中介者要知道具体的房主和租房者
        mediator.setTenant(tenant);
        mediator.setHouseOwner(houseOwner);

        tenant.connect("我要租房～");
        houseOwner.connect("可以， 有房～");

    }
}
