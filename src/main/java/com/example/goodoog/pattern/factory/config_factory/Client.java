package com.example.goodoog.pattern.factory.config_factory;

public class Client {
    public static void main(String[] args) {
        Coffee coffee = CoffeeFactory.createCoffee("american");
        System.out.println(coffee.getName());

        System.out.println("-------------------");
        Coffee coffee2 = CoffeeFactory.createCoffee("latte");
        System.out.println(coffee2.getName());
    }
}
