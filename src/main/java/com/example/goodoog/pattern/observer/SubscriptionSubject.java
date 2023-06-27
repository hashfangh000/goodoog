package com.example.goodoog.pattern.observer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 具体主题角色类
 */
public class SubscriptionSubject implements Subject{

    // 定义一个集合用来存储多个观察者对象
    private List<Observer> weiXinUserList = new ArrayList<Observer>();
    @Override
    public void attach(Observer observer) {
        weiXinUserList.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        weiXinUserList.remove(observer);
    }

    @Override
    public void notify(String msg) {
        for (Observer observer : weiXinUserList) {
            observer.update(msg);
        }
    }
}
