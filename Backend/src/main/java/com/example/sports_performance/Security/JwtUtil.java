package com.example.sports_performance.Security;

import com.example.sports_performance.Model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

@Service
public class JwtUtil {

    private final SecretKey SECRET_KEY = Keys.hmacShaKeyFor("Nt4Gpzgb5D4E8OMiUGtyuKjMTffSp0yj".getBytes());

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Encode the password
    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    public boolean validatePassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }

    // Generate JWT token
    public String generateToken(User user) {
        Claims claims = Jwts.claims().setSubject(user.getUsername());
        claims.put("role", user.getRole()); // Add role to token claims

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours expiry
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    // Validate JWT token
    public Boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    // Get user from token
    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject(); // Extracting the username (or user ID)
    }

    public String getRoleFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
        return claims.get("role", String.class); // Assuming 'role' is stored in the token
    }
}
