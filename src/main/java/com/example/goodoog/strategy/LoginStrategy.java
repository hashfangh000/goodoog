package com.example.goodoog.strategy;

import com.example.goodoog.dto.LoginDTO;
import com.example.goodoog.dto.R;

import javax.servlet.http.HttpSession;

public interface LoginStrategy {

    R login(LoginDTO loginDTO, HttpSession session);
}
