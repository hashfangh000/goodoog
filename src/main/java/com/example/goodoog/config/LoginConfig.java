package com.example.goodoog.config;

import com.example.goodoog.enums.LoginMethodEnum;
import com.example.goodoog.strategy.LoginStrategy;
import com.example.goodoog.strategy.strategies.AccountLoginStrategy;
import com.example.goodoog.strategy.strategies.CodeLoginStrategy;
import com.example.goodoog.strategy.strategies.EmialLoginStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

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
