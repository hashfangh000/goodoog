package com.example.goodoog.pattern.builder.demo1;

public class Client {
    public static void main(String[] args) {
        Director director = new Director(new MobileBuilder());
        // 指挥者 指挥组装自行车
        Bike bike = director.construct();
        System.out.println(bike.getFrame());
        System.out.println(bike.getSeat());
    }
}
