package com.example.goodoog.controller;

import com.example.goodoog.dto.LoginDTO;
import com.example.goodoog.dto.R;
import com.example.goodoog.service.IUserService;
import com.example.goodoog.service.LoginStrategyService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private IUserService userService;

    @Resource
    private Map<String, LoginStrategyService> loginStrategyMap;

//    @Resource
//    private CodeLoginStrategy codeLoginStrategy;
//
//    @Resource
//    private AccountLoginStrategy accountLoginStrategy;
//
//    @Resource
//    private EmialLoginStrategy emialLoginStrategy;

    @PostMapping("login")
    public R login(@RequestBody LoginDTO loginDTO, HttpSession session) {
        String method = loginDTO.getMethod();
        LoginStrategyService strategy = loginStrategyMap.get(method);
        return strategy.login(loginDTO, session);
    }

    @PostMapping("/sendCode")
    public R sendCode(@RequestParam("phone") String phone) {
        return userService.sendCode(phone);
    }

}
