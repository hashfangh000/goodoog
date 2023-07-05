package com.example.goodoog.processor;


import com.example.goodoog.entity.Cat;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Cat bean = context.getBean(Cat.class);
        System.out.println(bean);

    }
}
