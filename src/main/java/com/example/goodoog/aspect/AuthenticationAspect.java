package com.example.goodoog.aspect;


import cn.hutool.core.util.StrUtil;
import com.example.goodoog.annotation.Authenticated;
import com.example.goodoog.dto.LoginDTO;
import com.example.goodoog.dto.R;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
public class AuthenticationAspect {

    @Before("@annotation(authenticated)")
    public R authenticate(JoinPoint joinPoint, Authenticated authenticated) {
        String[] roles = authenticated.roles();
        LoginDTO user = (LoginDTO)joinPoint.getArgs()[0];
        if (user == null || !hasAnyRole(user, roles)) {
            return R.fail("当前用户无权限！");
        }
        return R.ok();
//        System.out.println("@before 开始");
//        System.out.println("注解参数:"+ Arrays.toString(roles));
//        System.out.println("目标方法的参数对象:" + joinPoint.getArgs()[0].);
//        System.out.println("被代理的对象:" + joinPoint.getTarget());
//        System.out.println("代理对象:" + joinPoint.getThis());
//        System.out.println("目标方法名为:" + joinPoint.getSignature().getName());
//        System.out.println("目标方法所属类的简单类名:" + joinPoint.getSignature().getDeclaringType().getSimpleName());
//        System.out.println("目标方法所属类的类名:" + joinPoint.getSignature().getDeclaringTypeName());
//        System.out.println("目标方法声明类型:" + Modifier.toString(joinPoint.getSignature().getModifiers()));
    }

    private boolean hasAnyRole(LoginDTO user, String[] roles) {
        String role = user.getRole();
        if (StrUtil.isBlank(role)) {
            return false;
        }
        return Arrays.asList(roles).contains(role);
    }
}
