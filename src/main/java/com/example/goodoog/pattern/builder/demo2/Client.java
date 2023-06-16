package com.example.goodoog.pattern.builder.demo2;

public class Client {
    // 创建手机对象
    public static void main(String[] args) {
        // 创建手机对象，通过构建者创建
        Phone phone = new Phone.Builder()
                .cpu("intel")
                .screen("三星屏幕")
                .memory("金士顿")
                .mainBoard("华硕主板")
                .build();
        System.out.println(phone);
    }
}
