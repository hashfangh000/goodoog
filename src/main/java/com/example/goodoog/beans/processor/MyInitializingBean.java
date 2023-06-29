package com.example.goodoog.beans.processor;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class MyInitializingBean implements InitializingBean {
    public MyInitializingBean(){
        System.out.println("MyInitializingBean....");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("MyInitializingBean...afterPropertiesSet...");
    }
}
