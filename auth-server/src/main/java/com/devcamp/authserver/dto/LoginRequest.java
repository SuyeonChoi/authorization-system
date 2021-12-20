package com.devcamp.authserver.dto;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
public class LoginRequest {
    @NotEmpty
    @Size(max = 60)
    private String email;

    @NotEmpty
    @Size(max = 32)
    private String password;
}
