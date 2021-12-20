package com.devcamp.authserver.service;

import com.devcamp.authserver.config.JwtConfig;
import com.devcamp.authserver.domain.User;
import com.devcamp.authserver.domain.UserRepository;
import com.devcamp.authserver.dto.LoginRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;


@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class AuthService {
    private final UserRepository userRepository;
    private final JwtConfig jwtConfig;

    public String setToken(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(EntityNotFoundException::new);

        //TODO: 비밀번호 확인 및 유효성 검사

        return jwtConfig.createToken(user.getEmail());
    }
}
