package com.company.user.auth.v1.dto;

import lombok.Data;

@Data
public class AuthLoginRequest {
    private String email;
    private String password;
}