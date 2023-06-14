package com.example.goodoog.annotation;

import java.lang.annotation.*;

// 元注解
// @Target 作用域
@Target(value = {ElementType.METHOD, ElementType.TYPE})
// @Retention 表示注解在什么地方有效 runtime>class>sources
@Retention(value = RetentionPolicy.RUNTIME)
// @Documented 表示是否将注解生成JavaDoc中
@Documented
// @Inherited 子类可以继承父类的注解
@Inherited
public @interface Debug {
    // 注解的参数，参数类型 + 参数名 ()
    String name() default "";
    int age() default 0;
    int id() default -1;    // 默认 -1 代表不存在
    String[] schools() default {"张三", "李四"};
}
