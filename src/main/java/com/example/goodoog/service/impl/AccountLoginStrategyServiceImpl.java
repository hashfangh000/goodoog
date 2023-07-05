package com.example.goodoog.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.goodoog.dto.LoginDTO;
import com.example.goodoog.dto.R;
import com.example.goodoog.entity.User;
import com.example.goodoog.mapper.UserMapper;
import com.example.goodoog.service.IUserService;
import com.example.goodoog.service.LoginStrategyService;
import com.example.goodoog.utils.MD5Util;
import com.example.goodoog.utils.RegexUtils;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
@Service
public class AccountLoginStrategyServiceImpl extends ServiceImpl<UserMapper, User> implements LoginStrategyService {

    @Resource
    private CodeLoginStrategyServiceImpl codeLoginStrategy;

    /**
     *
     * @param loginDTO 用户请求数据
     * @param session session
     * @return R
     */
    @Override
    public R login(LoginDTO loginDTO, HttpSession session) {

        String phone = loginDTO.getPhone();
        String password = loginDTO.getPassword();
        if (!StrUtil.isBlank(phone) || StrUtil.isBlank(password)) {
            return R.fail("请输入账号或者密码！");
        }
        // 1.验证手机号合法
        if (!RegexUtils.isPhoneInvalid(phone)) {
            return R.fail("手机号格式不合法！");
        }

        // 2. 是否存在用户
        User user = query().eq("phone", phone).one();
        if (null == user) {
            // 创建用户
            return R.fail("当前用户不存在！");
        }
        // 3.密码是否正确
        if (!authenticate(user.getPassword(), password)) {
            return R.fail("密码错误，请重新输入！");
        }

        return codeLoginStrategy.cacheUser(user);

    }

    public boolean authenticate(String dbPassword, String password) {
        return MD5Util.formToDB(password, MD5Util.SALT).equals(dbPassword);
    }

}
