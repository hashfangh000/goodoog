package com.example.goodoog.dto;

import lombok.Data;
import lombok.NonNull;

@Data
public class LoginDTO {
    private String phone;
    private String code;
    private String password;
    @NonNull
    private String method;
}
