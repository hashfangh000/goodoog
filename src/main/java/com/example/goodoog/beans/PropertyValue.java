package com.example.goodoog.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用来封装bean标签下的property标签的属性
 *  name
 *  ref
 *  value ： 给基本数据类型及string类型数据所赋的值
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PropertyValue {
    private String name;
    private String ref;
    private String value;
}
