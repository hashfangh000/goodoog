package com.example.goodoog.config;

import com.example.goodoog.enums.LoginMethodEnum;
import com.example.goodoog.strategy.LoginStrategy;
import com.example.goodoog.strategy.strategies.AccountLoginStrategy;
import com.example.goodoog.strategy.strategies.CodeLoginStrategy;
import com.example.goodoog.strategy.strategies.EmialLoginStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class LoginConfig {
    @Bean
    public Map<String, LoginStrategy> loginStrategyMap(
            CodeLoginStrategy codeStrategy,
            AccountLoginStrategy accountLoginStrategy,
            EmialLoginStrategy emialLoginStrategy){
        Map<String, LoginStrategy> loginStrategyMap = new HashMap<>();
        loginStrategyMap.put(LoginMethodEnum.CODE.getMethod(), codeStrategy);
        loginStrategyMap.put(LoginMethodEnum.ACCOUNT.getMethod(), accountLoginStrategy);
        loginStrategyMap.put(LoginMethodEnum.EMIAL.getMethod(), emialLoginStrategy);
        return loginStrategyMap;
    }
}
