package com.example.goodoog.pattern.strategy;

import java.util.Arrays;
import java.util.Comparator;

public class Client {
    public static void main(String[] args) {
        // 春节来临 使用春节促销活动
        SalesMan salesMan = new SalesMan(new StrategyA());
        // 展示促销活动
        salesMan.salesManShow();

        System.out.println("----------------------");
        salesMan.setStrategy(new StrategyB());
        salesMan.salesManShow();

        System.out.println("----------------------");
        salesMan.setStrategy(new StrategyC());
        salesMan.salesManShow();

    }
}
