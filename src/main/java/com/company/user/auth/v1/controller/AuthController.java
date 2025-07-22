package com.company.user.auth.v1.controller;

import com.company.user.auth.v1.dto.AuthLoginRequest;
import com.company.user.auth.v1.dto.AuthResponse;
import com.company.user.auth.v1.service.AuthService;
import com.company.user.lib.core.v1.master.user.dto.UserDto;
import com.company.user.lib.core.v1.master.user.dto.UserRegisterRequest;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody UserRegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody AuthLoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping("/profile")
    public ResponseEntity<UserDto> getProfile(HttpServletRequest request) {
        String email = (String) request.getAttribute("userEmail");
        UserDto user = authService.getProfile(email);
        return ResponseEntity.ok(user);
    }


    @GetMapping("/ping")
    public String ping() {
        return "auth-service running";
    }
}