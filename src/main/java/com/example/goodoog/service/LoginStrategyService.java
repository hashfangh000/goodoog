package com.example.goodoog.service;

import com.example.goodoog.dto.LoginDTO;
import com.example.goodoog.dto.R;

import javax.servlet.http.HttpSession;

public interface LoginStrategyService {

    R login(LoginDTO loginDTO, HttpSession session);
}
