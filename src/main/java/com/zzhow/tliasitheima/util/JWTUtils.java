package com.zzhow.tliasitheima.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.security.SignatureException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

/**
 * @author ZZHow
 * @date 2024/7/27
 */
@Slf4j
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
                .expiration(new Date(System.currentTimeMillis() + expiration))
                .compact();
    }

    public Claims parseToken(String token) {
        Claims claims = null;

        try {
            claims = (Claims) Jwts.parser()
                    .verifyWith(key)
                    .build()
                    .parse(token)
                    .getPayload();
        } catch (ExpiredJwtException e) {
            log.info("JWT 令牌过期：{}", e.getMessage());
        } catch(MalformedJwtException e) {
            log.info("JWT 令牌格式无效：{}", e.getMessage());
        } catch (SignatureException e) {
            log.info("JWT 令牌签名验证失败：{}", e.getMessage());
        } catch(SecurityException e) {
            log.info("JWT 令牌安全性检查失败：{}", e.getMessage());
        } catch(IllegalArgumentException e) {
            log.info("JWT 令牌参数不合法：{}", e.getMessage());
        }

        return claims;
    }
}
