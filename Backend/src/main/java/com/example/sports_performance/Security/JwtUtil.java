package com.example.sports_performance.Security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys; // Import Keys class
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey; // Import SecretKey class
import java.util.Date;

@Component
public class JwtUtil {
    private final SecretKey secretKey = Keys.hmacShaKeyFor("Nt4Gpzgb5D4E8OMiUGtyuKjMTffSp0yj".getBytes()); // Generate SecretKey

    public String generateToken(String username) {
        long expirationTime = 1000 * 60 * 60; // 1 day
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationTime))
                .signWith(secretKey) // Updated to use SecretKey
                .compact();
    }

    public boolean validateToken(String token, String username) {
        String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }

    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parserBuilder() // Updated to use parserBuilder
                .setSigningKey(secretKey) // Use the SecretKey for verification
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    private boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }
}
