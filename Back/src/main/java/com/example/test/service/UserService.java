package com.example.test.service;


import com.example.test.security.dto.LoginRequest;
import com.example.test.security.dto.LoginResponse;
import com.example.test.security.dto.UserProfile;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {
    ResponseEntity<LoginResponse> login(LoginRequest loginRequest, String accessToken, String refreshToken);

    ResponseEntity<LoginResponse> refresh(String accessToken, String refreshToken);

    UserProfile getUserProfile();
    String logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse);

}
