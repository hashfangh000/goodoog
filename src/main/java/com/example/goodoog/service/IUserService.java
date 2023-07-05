package com.example.goodoog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.goodoog.dto.R;
import com.example.goodoog.entity.User;


public interface IUserService extends IService<User> {

    R sendCode(String phone);
}
