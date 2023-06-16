package com.example.goodoog.pattern.decorator;

public class Client {
    public static void main(String[] args) {
        // 炒饭
        FastFood food = new FriedRice();

        System.out.println(food.getDesc() + " " + food.cost() + "元");

        System.out.println("----------------------");

        // 加鸡蛋
        food = new Egg(food);
        System.out.println(food.getDesc() + " " + food.cost() + "元");

        System.out.println("----------------------");

        // 加鸡蛋
        food = new Egg(food);
        System.out.println(food.getDesc() + " " + food.cost() + "元");

        System.out.println("----------------------");

        // 加鸡蛋
        food = new Bacon(food);
        System.out.println(food.getDesc() + " " + food.cost() + "元");
    }
}
