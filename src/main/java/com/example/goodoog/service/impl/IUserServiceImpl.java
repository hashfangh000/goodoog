package com.example.goodoog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.goodoog.dto.LoginDTO;
import com.example.goodoog.dto.R;
import com.example.goodoog.entity.User;
import com.example.goodoog.mapper.UserMapper;
import com.example.goodoog.service.IUserService;
import com.example.goodoog.strategy.LoginStrategy;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Service
public class IUserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService, LoginStrategy{
    @Resource
    private Map<String, LoginStrategy> loginStrategyMap;
    @Override
    public R login(LoginDTO loginDTO, HttpSession session) {
        return loginStrategyMap.get(loginDTO.getMethod()).login(loginDTO, session);
    }
}
