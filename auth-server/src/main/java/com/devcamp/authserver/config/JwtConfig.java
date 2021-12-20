package com.devcamp.authserver.config;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtConfig {
    @Value(value = "${jwt.secret}")
    private String secret;

    @Value(value = "${jwt.expiration-length}")
    private Long validityInMilliseconds;

    public String createToken(String subject) {
        Date now = new Date();
        return Jwts.builder()
                .setClaims(Jwts.claims().setSubject(subject))
                .setIssuedAt(now)
                .setExpiration(generateExpirationDate(now))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    private Date generateExpirationDate(Date now) {
        return new Date(now.getTime() + validityInMilliseconds);
    }
}
