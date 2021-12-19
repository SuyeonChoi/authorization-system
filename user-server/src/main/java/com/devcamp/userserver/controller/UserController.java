package com.devcamp.userserver.controller;

import com.devcamp.userserver.dto.SignUpRequest;
import com.devcamp.userserver.service.UserService;
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
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<Void> signup(@RequestBody @Valid SignUpRequest request) {
        long id = userService.create(request);
        log.info("[USER SIGN UP] : " + id);
        return ResponseEntity.ok().build();
    }
}
