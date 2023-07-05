package com.example.goodoog.pattern.builder.demo1;

public class Director {

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    // 组装自行车功能
    public Bike construct() {
        builder.builderFrame();
        builder.builderSeat();
        return builder.createBike();
    }
}
