package com.example.goodoog.utils;

public class StringUtils {
    private StringUtils() {
    }

    // userDao --> serUserDao
    public static String getSetterMethodByFieldName(String fieldName) {
        return "set" + fieldName.substring(0,1).toUpperCase() + fieldName.substring(1);
    }
}
