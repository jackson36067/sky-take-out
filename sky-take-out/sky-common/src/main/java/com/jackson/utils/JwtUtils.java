package com.jackson.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

@Component
public class JwtUtils {

    /**
     * 生成jwt令牌
     *
     * @param secretKey jwt密钥
     * @param ttlMills  jwt过期时间
     * @param claims    设置的信息
     * @return
     */
    public static String genJwt(String secretKey, long ttlMills, Map<String, Object> claims) {
        String token = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + ttlMills))
                .compact();
        return token;
    }

    /**
     *
     * @param token jwt令牌
     * @param secretKey jwt密钥
     * @return
     */
    public static Claims parseJwt(String token, String secretKey) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey.getBytes(StandardCharsets.UTF_8))
                .parseClaimsJws(token)
                .getBody();
        return claims;
    }
}
