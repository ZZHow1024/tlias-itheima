package com.zzhow.tliasitheima.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author ZZHow
 * @date 2024/7/27
 */
@Data
@ConfigurationProperties(prefix = "jwt.configuration")
@Component
public class JWTProperties {
    private Long expiration;
}
