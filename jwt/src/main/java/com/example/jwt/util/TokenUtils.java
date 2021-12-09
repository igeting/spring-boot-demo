package com.example.jwt.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.jwt.entity.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenUtils {
    @Value(value = "${jwt.sign}")
    private String sign;

    public String getToken(User user, long expire) {
        JWTCreator.Builder builder = JWT.create();
        builder.withExpiresAt(new Date(System.currentTimeMillis() + expire));
        builder.withAudience(user.getId());
        //String token = builder.sign(Algorithm.HMAC256(user.getPassword()));
        String token = builder.sign(Algorithm.HMAC256(sign));
        return token;
    }
}
