package com.example.goodoog.strategy.strategies;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.goodoog.dto.LoginDTO;
import com.example.goodoog.dto.R;
import com.example.goodoog.entity.User;
import com.example.goodoog.mapper.UserMapper;
import com.example.goodoog.strategy.LoginStrategy;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Component
public class EmialLoginStrategy extends ServiceImpl<UserMapper, User> implements LoginStrategy {
    @Override
    public R login(LoginDTO loginDTO, HttpSession session) {
        return R.ok("当前登陆：邮箱");
    }
}
