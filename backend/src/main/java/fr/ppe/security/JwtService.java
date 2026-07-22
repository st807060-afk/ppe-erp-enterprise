package fr.ppe.security;

import org.springframework.stereotype.Service;

@Service
public class JwtService {

    private static final String SECRET_KEY =
            "change-this-secret-key-with-a-long-random-value";

    public String generateToken(String username) {
        return "TOKEN_" + username;
    }

    public boolean validateToken(String token) {
        return token != null && token.startsWith("TOKEN_");
    }

    public String extractUsername(String token) {
        return token.replace("TOKEN_", "");
    }
}
