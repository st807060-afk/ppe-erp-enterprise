package com.ppe.erp.service;

import com.ppe.erp.dto.LoginRequest;
import com.ppe.erp.dto.LoginResponse;
import com.ppe.erp.entity.User;
import com.ppe.erp.repository.UserRepository;
import com.ppe.erp.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final UserRepository userRepository;

    public LoginResponse authenticate(LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.password()
                )
        );

        User user = userRepository.findByEmail(request.email())
                .orElseThrow();

        String token = jwtService.generateToken(user);

        return new LoginResponse(token, "Bearer");
    }
}
