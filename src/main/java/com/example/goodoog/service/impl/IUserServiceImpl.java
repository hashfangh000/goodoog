package com.example.goodoog.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.goodoog.dto.R;
import com.example.goodoog.entity.User;
import com.example.goodoog.mapper.UserMapper;
import com.example.goodoog.service.IUserService;
import com.example.goodoog.utils.RegexUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

import static com.example.goodoog.utils.RedisConstants.LOGIN_CODE_KEY;
import static com.example.goodoog.utils.RedisConstants.LOGIN_CODE_TTL;

@Service
@Slf4j
public class IUserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private  StringRedisTemplate stringRedisTemplate;


    @Override
    public R sendCode(String phone) {
        if (!RegexUtils.isPhoneInvalid(phone)) {
            return R.fail("手机号格式不合法！");
        }
        String code = RandomUtil.randomNumbers(6);
        stringRedisTemplate.opsForValue().set(LOGIN_CODE_KEY + phone, code, LOGIN_CODE_TTL, TimeUnit.MINUTES);
        log.debug("发送短信验证码成功：{}，两分钟有效", code);
        return R.ok(200);
    }


}
