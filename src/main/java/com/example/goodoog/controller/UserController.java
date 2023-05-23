package com.example.goodoog.controller;

import com.example.goodoog.dto.LoginDTO;
import com.example.goodoog.dto.R;
import com.example.goodoog.service.IUserService;
import com.example.goodoog.strategy.LoginStrategy;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    private  Map<String, LoginStrategy> loginStrategyMap;

//    public UserController(Map<String, LoginStrategy> loginStrategyMap) {
//        this.loginStrategyMap = loginStrategyMap;
//    }

    @PostMapping("login")
    public R login(@RequestBody LoginDTO loginDTO, HttpSession session) {
        String method = loginDTO.getMethod();
        LoginStrategy strategy = loginStrategyMap.get(method);
        return strategy.login(loginDTO, session);
    }
}
