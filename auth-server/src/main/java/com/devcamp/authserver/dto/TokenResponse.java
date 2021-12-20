package com.devcamp.authserver.dto;

import lombok.Getter;

@Getter
public class TokenResponse {
    private String accessToken;
    private String tokenType;

    public TokenResponse(String accessToken, String tokenType) {
        this.accessToken = accessToken;
        this.tokenType = tokenType;
    }
}
