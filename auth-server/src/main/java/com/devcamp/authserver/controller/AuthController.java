package com.devcamp.authserver.controller;

import com.devcamp.authserver.dto.LoginRequest;
import com.devcamp.authserver.dto.TokenResponse;
import com.devcamp.authserver.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<TokenResponse>  login(@RequestBody @Valid LoginRequest request) {
        log.info("[LOGIN REQUEST] " + request.getEmail());
        String accessToken = authService.setToken(request);
        return ResponseEntity.ok().body(new TokenResponse(accessToken, "bearer"));
    }
}
