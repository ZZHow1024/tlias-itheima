package com.zzhow.tliasitheima.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

/**
 * @author ZZHow
 * @date 2024/7/27
 */
@Component
public class JWTUtils {
    @Autowired
    private JWTProperties jwtProperties;
    private final SecretKey key = Jwts.SIG.HS256.key().build();

    public String generateToken(Map<String, Object> claims) {
        Long expiration = jwtProperties.getExpiration();

        return Jwts.builder()
                .claims(claims)
                .signWith(key, Jwts.SIG.HS256)
                .expiration(new Date(System.currentTimeMillis() + expiration * 1000 * 3600))
                .compact();
    }

    public Claims parseToken(String token) {
        return (Claims) Jwts.parser()
                .verifyWith(key)
                .build()
                .parse(token)
                .getPayload();
    }
}
