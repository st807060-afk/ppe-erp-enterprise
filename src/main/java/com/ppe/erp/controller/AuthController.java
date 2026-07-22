package com.ppe.erp.controller;

import com.ppe.erp.dto.LoginRequest;
import com.ppe.erp.dto.LoginResponse;
import com.ppe.erp.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public LoginResponse login(@Valid @RequestBody LoginRequest request) {
        return authenticationService.authenticate(request);
    }
}
