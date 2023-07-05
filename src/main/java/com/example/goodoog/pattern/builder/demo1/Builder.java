package com.example.goodoog.pattern.builder.demo1;

public abstract class Builder {
    // 声明Bike类型变量，并赋值
    protected Bike bike = new Bike();

    public abstract void builderFrame();
    public abstract void builderSeat();

    // 构建自行车
    public abstract Bike createBike();
}
