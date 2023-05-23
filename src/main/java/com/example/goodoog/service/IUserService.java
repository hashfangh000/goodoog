package com.example.goodoog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.goodoog.dto.LoginDTO;
import com.example.goodoog.dto.R;
import com.example.goodoog.entity.User;

import javax.servlet.http.HttpSession;

public interface IUserService extends IService<User> {

}
