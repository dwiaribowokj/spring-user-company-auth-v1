package com.company.user.auth.v1.service;

import com.company.user.auth.v1.dto.AuthLoginRequest;
import com.company.user.auth.v1.dto.AuthResponse;
import com.company.user.auth.v1.util.JwtUtil;
import com.company.user.lib.core.v1.master.user.User;
import com.company.user.lib.core.v1.master.user.UserService;
import com.company.user.lib.core.v1.master.user.dto.UserDto;
import com.company.user.lib.core.v1.master.user.dto.UserRegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final UserService userService;

    @Transactional
    @Override
    public AuthResponse register(UserRegisterRequest request) {
        UserDto userDto = userService.register(request);
        String token = jwtUtil.generateToken(userDto.getEmail());
        return new AuthResponse(token);
    }

    @Override
    public AuthResponse login(AuthLoginRequest request) {
        User user = userService.findByEmail(request.getEmail());
        if (user == null || !passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new IllegalArgumentException("Email atau password salah");
        }

        String token = jwtUtil.generateToken(user.getEmail());
        return new AuthResponse(token);
    }

    @Override
    public UserDto getProfile(String email) {
        User user = userService.findByEmail(email);
        if (user == null) {
            throw new IllegalArgumentException("User tidak ditemukan");
        }
        return UserDto.fromEntity(user);
    }
}