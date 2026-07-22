package fr.ppe.service;

import fr.ppe.dto.LoginRequest;
import fr.ppe.dto.LoginResponse;
import fr.ppe.entity.User;
import fr.ppe.repository.UserRepository;
import fr.ppe.security.JwtService;
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
                        request.getUsername(),
                        request.getPassword()
                )
        );

        User user = userRepository.findByUsername(request.getusername())
                .orElseThrow();

        String token = jwtService.generateToken(user.getUsername());

        return new LoginResponse(token, "Bearer");
    }
}
