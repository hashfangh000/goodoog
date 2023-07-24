package com.example.goodoog.entity;

import lombok.Data;

/**
 * @description:
 * @author: fanghao
 * @create: 2023/7/10
 **/
@Data
public class StudentQueryDto {
    private String name;
    private String sex;
    private Integer age;
    Integer maxA;
    int page;
    int size;

}
