package com.example.goodoog.enums;

public enum LoginMethodEnum {
    CODE("1"),
    EMIAL("2"),
    ACCOUNT("3");


    private String method;

    LoginMethodEnum(String method) {
        this.method = method;
    }

    public String getMethod() {
        return method;
    }
}
