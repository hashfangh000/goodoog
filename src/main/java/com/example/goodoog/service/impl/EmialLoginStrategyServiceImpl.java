package com.example.goodoog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.goodoog.dto.LoginDTO;
import com.example.goodoog.dto.R;
import com.example.goodoog.entity.User;
import com.example.goodoog.mapper.UserMapper;
import com.example.goodoog.service.LoginStrategyService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
@Service
public class EmialLoginStrategyServiceImpl extends ServiceImpl<UserMapper, User> implements LoginStrategyService {
    @Override
    public R login(LoginDTO loginDTO, HttpSession session) {
        return R.ok("当前登陆：邮箱");
    }
}
