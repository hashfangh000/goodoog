package com.example.goodoog.utils;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

@Component
public class MD5Util {
    public static String md5(String str) {
        return DigestUtils.md5Hex(str);
    }

    public static final String SALT = "1g2o3o4d5o6o7g";

    /**
     * 第一次加密
     */
    public static String inputToForm(String input) {
        String str = "" + SALT.charAt(0) + SALT.charAt(3) + input + SALT.charAt(4) + SALT.charAt(5);
        return md5(str);
    }

    public static String formToDB(String form, String salt) {
        String str = salt.charAt(0) + salt.charAt(3) + form + salt.charAt(4) + salt.charAt(5);
        return md5(str);
    }

    public static String inputToDB(String input, String salt) {
        String form = inputToForm(input);
        String db = formToDB(form, salt);
        return db;
    }

    public static void main(String[] args) {
        System.out.println(inputToDB("123456", SALT));
    }
}
