package com.novellahub.auth.controller;

import com.novellahub.auth.dto.AuthResponse;
import com.novellahub.auth.dto.LoginRequest;
import com.novellahub.auth.dto.RegisterRequest;
import com.novellahub.auth.dto.UserResponse;
import com.novellahub.auth.entity.NguoiDung;
import com.novellahub.auth.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody LoginRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping("/me")
    public ResponseEntity<UserResponse> me(@AuthenticationPrincipal NguoiDung user) {
        UserResponse response = new UserResponse(user.getId(), user.getUsername(), user.getEmail(), user.getRole());
        return ResponseEntity.ok(response);
    }
}
