package com.company.user.auth.v1.service;

import com.company.user.auth.v1.dto.AuthLoginRequest;
import com.company.user.auth.v1.dto.AuthResponse;
import com.company.user.lib.core.v1.master.user.dto.UserDto;
import com.company.user.lib.core.v1.master.user.dto.UserRegisterRequest;

public interface AuthService {
    AuthResponse register(UserRegisterRequest request);
    AuthResponse login(AuthLoginRequest request);
    UserDto getProfile(String email);
}