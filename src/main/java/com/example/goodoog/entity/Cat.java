package com.example.goodoog.entity;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Cat {
    public Cat(){
//        System.out.println("cat被创建了...");
    }

    private String name;


    @Value("${server.port}") //自动赋值功能
    public void setName(String name) {
//        System.out.println("cat....setName正在赋值调用....");
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
