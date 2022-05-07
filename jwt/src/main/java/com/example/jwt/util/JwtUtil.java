package com.example.jwt.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    private static String algorithm;
    private static int expire;

    @Value("${core.jwt.algorithm}")
    public void setAlgorithm(String algorithm) {
        JwtUtil.algorithm = algorithm;
    }

    @Value("${core.jwt.expire}")
    public void setExpire(int expire) {
        JwtUtil.expire = expire;
    }

    public static String create(String id) {
        try {
            String token = JWT.create()
                    .withAudience(id)
                    .withExpiresAt(new Date(new Date().getTime() + expire * 60 * 1000))
                    .sign(Algorithm.HMAC256(algorithm));
            return token;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean verify(String token) {
        try {
            Date expires = JWT.require(Algorithm.HMAC256(algorithm)).build()
                    .verify(token)
                    .getExpiresAt();
            if (expires.after(new Date())) {
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String id(String token) {
        try {
            return JWT.require(Algorithm.HMAC256(algorithm)).build()
                    .verify(token)
                    .getAudience()
                    .get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
