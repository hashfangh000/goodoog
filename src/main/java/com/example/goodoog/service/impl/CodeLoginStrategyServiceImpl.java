package com.example.goodoog.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.bean.copier.CopyOptions;
import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.goodoog.dto.LoginDTO;
import com.example.goodoog.dto.R;
import com.example.goodoog.dto.UserDTO;
import com.example.goodoog.entity.User;
import com.example.goodoog.mapper.UserMapper;
import com.example.goodoog.service.LoginStrategyService;
import com.example.goodoog.utils.RegexUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static com.example.goodoog.utils.RedisConstants.*;
import static com.example.goodoog.utils.SystemConstants.USER_NICK_NAME_PREFIX;

/**
 * 验证码登陆
 */
@Slf4j
@Service
public class CodeLoginStrategyServiceImpl extends ServiceImpl<UserMapper, User> implements LoginStrategyService {

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public R login(LoginDTO loginDTO, HttpSession session) {
//        return R.ok("当前登陆：验证码");
        String phone = loginDTO.getPhone();
        if (!RegexUtils.isPhoneInvalid(phone)) {
            return R.fail("手机号格式不合法！");
        }
        String code = loginDTO.getCode();
        String cachecode = stringRedisTemplate.opsForValue().get(LOGIN_CODE_KEY + phone);
        if (cachecode == null || !cachecode.equals(code)) {
            return R.fail("验证码错误");
        }
        User user = query().eq("phone", phone).one();
        if (null == user) {
            user = createUserWithPhone(phone);
        }
        return cacheUser(user);
    }

    public R cacheUser(User user) {
        String token = UUID.randomUUID().toString(true);
        UserDTO userDTO = BeanUtil.copyProperties(user, UserDTO.class);
        Map<String, Object> userMap = BeanUtil.beanToMap(userDTO, new HashMap<>(),
                CopyOptions.create()
                        .setIgnoreNullValue(true)
                        .setFieldValueEditor((fieldName, fieldValue) -> fieldValue.toString()));
        String tokenKey = LOGIN_USER_KEY + token;
        // 存储
        stringRedisTemplate.opsForHash().putAll(tokenKey,  userMap); // 存时需要设置过期时间
        stringRedisTemplate.expire(tokenKey, CACHE_SHOP_TTL, TimeUnit.MINUTES);
        // 存储
        // 8.返回结果
        return R.ok(token);
    }

    private User createUserWithPhone(String phone) {
        // 1.创建用户
        User user = new User();
        user.setPhone(phone);
        // user_+10位随机字符串
        user.setNickName(USER_NICK_NAME_PREFIX + RandomUtil.randomString(10));
        // 2.保存用户
        // mybatis-plus保存用户，插入
        save(user);
        return user;
    }
}
