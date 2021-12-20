package com.devcamp.userserver.dto;

import com.devcamp.userserver.domain.User;
import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
public class SignUpRequest {
    @NotEmpty
    @Size(max = 60)
    private String email;

    @NotEmpty
    @Size(max = 32)
    private String password;

    @NotEmpty
    @Size(max = 16)
    private String nickname;

    @NotEmpty
    @Size(max = 11)
    private String phoneNumber;

    public User toEntity() {
        return User.builder()
                .email(email)
                .password(password)
                .nickname(nickname)
                .phoneNumber(phoneNumber)
                .role((short) 0)
                .activation((short) 1)
                .build();
    }
}
