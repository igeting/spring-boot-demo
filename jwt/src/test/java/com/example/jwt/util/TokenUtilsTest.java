package com.example.jwt.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.jwt.JwtApplication;
import com.example.jwt.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = JwtApplication.class)
class TokenUtilsTest {

    @Autowired
    private TokenUtils tokenUtils;

    @Value(value = "${jwt.sign}")
    private String sign;

    @Test
    void getToken() throws Exception {
        User user = new User();
        user.setId("001");
        user.setUsername("jack");
        user.setPassword("123456");

        //生成token
        String token = tokenUtils.getToken(user);
        System.out.println(token);

        //验证token
        DecodedJWT decode = JWT.decode(token);
        String id = decode.getAudience().get(0);
        System.out.println(id);
        //String password = user.getPassword(); //正常应该根据id从数据库获取password
        //JWTVerifier verifier = JWT.require(Algorithm.HMAC256(password)).build();
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(sign)).build();
        try {
            verifier.verify(token);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("verify fail");
        }
    }
}