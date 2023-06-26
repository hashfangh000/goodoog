package com.example.goodoog.pattern.responsibility;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 请假条类
 */
@Getter
@AllArgsConstructor
public class LeaveRequest {

    private String name;

    private int num;

    private String content;

}
