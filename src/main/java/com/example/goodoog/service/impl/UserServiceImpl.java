package com.example.goodoog.service.impl;

import com.example.goodoog.dao.UserDao;
import com.example.goodoog.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl() {
        System.out.println("userService被创建了～");
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void add() {
        System.out.println("UserService......");
        userDao.add();
    }
}
