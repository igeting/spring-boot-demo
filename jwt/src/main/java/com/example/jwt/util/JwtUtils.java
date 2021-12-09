package com.example.jwt.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.CompressionCodecs;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    public static String createToken(String key, String username, String role, long expire) {
        String token = Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis() + expire))
                .setSubject(username)
                .claim("username", username)
                .claim("role", role)
                .signWith(SignatureAlgorithm.HS256, key)
                .compressWith(CompressionCodecs.GZIP).compact();
        return token;
    }

    public static String getSubjectFromToken(String key, String token) {
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    public static String getObjectFromToken(String key, String token, String name) {
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        return claims.get(name).toString();
    }
}
