package com.example.goodoog.config;

import com.example.goodoog.enums.LoginMethodEnum;
import com.example.goodoog.service.LoginStrategyService;
import com.example.goodoog.service.impl.AccountLoginStrategyServiceImpl;
import com.example.goodoog.service.impl.CodeLoginStrategyServiceImpl;
import com.example.goodoog.service.impl.EmialLoginStrategyServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class LoginConfig {

    @Bean
    public Map<String, LoginStrategyService> loginStrategyMap(
            CodeLoginStrategyServiceImpl codeStrategy,
            AccountLoginStrategyServiceImpl accountLoginStrategy,
            EmialLoginStrategyServiceImpl emialLoginStrategy){
        Map<String, LoginStrategyService> loginStrategyMap = new HashMap<>();
        loginStrategyMap.put(LoginMethodEnum.CODE.getMethod(), codeStrategy);
        loginStrategyMap.put(LoginMethodEnum.EMIAL.getMethod(), emialLoginStrategy);
        loginStrategyMap.put(LoginMethodEnum.ACCOUNT.getMethod(), accountLoginStrategy);
        return loginStrategyMap;
    }


//    @Bean
//    public CodeLoginStrategy codeLoginStrategy() {
//        return new CodeLoginStrategy();
//    }
//
//    @Bean
//    public AccountLoginStrategy accountLoginStrategy() {
//        return new AccountLoginStrategy();
//    }
//
//    @Bean
//    public EmialLoginStrategy emialLoginStrategy() {
//        return new EmialLoginStrategy();
//    }
}
