package com.devcamp.userserver.service;

import com.devcamp.userserver.domain.User;
import com.devcamp.userserver.domain.UserRepository;
import com.devcamp.userserver.dto.SignUpRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.transaction.Transactional;

@Slf4j
@RequiredArgsConstructor
@Transactional
@Service
public class UserService {
    private final UserRepository userRepository;

    public Long create(SignUpRequest request) {
        if (userRepository.existsByEmail(request.getEmail()))
            throw new EntityExistsException("이미 존재하는 이메일입니다.");
        if (userRepository.existsByPhoneNumber(request.getPhoneNumber()))
            throw new EntityExistsException("이미 존재하는 전화번호입니다.");

        // TODO: 비밀번호 암호화

        User user = request.toEntity();
        User savedUser = userRepository.save(user);
        return savedUser.getId();
    }
}
