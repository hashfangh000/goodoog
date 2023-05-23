package com.example.goodoog.strategy.strategies;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.goodoog.dto.LoginDTO;
import com.example.goodoog.dto.R;
import com.example.goodoog.entity.User;
import com.example.goodoog.mapper.UserMapper;
import com.example.goodoog.strategy.LoginStrategy;
import com.example.goodoog.utils.RegexUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;


import javax.servlet.http.HttpSession;
@Component
public class AccountLoginStrategy extends ServiceImpl<UserMapper, User> implements LoginStrategy {

//    @Resource
//    private StringRedisTemplate stringRedisTemplate;
    /**
     *
     * @param loginDTO
     * @return
     */
    @Override
    public R login(LoginDTO loginDTO, HttpSession session) {
        return R.ok("当前登陆：账号密码");
//        String phone = loginDTO.getPhone();
//        String password = loginDTO.getPassword();
//        // 验证手机号合法
//        if (!RegexUtils.isPhoneInvalid(phone)) {
//            return R.fail("手机号格式不合法！");
//        }

//        // 是否存在用户
//        User user = query().eq("phone", phone).one();
//        if (null == user) {
//            // 创建用户
//            return R.fail("当前用户不存在！");
//        }
//        // 密码是否正确
//
//        // return



    }

}
