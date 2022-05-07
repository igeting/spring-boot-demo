package com.example.jwt.util;

import com.example.jwt.JwtApplication;
import com.example.jwt.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = JwtApplication.class)
public class JwtUtilTest {

    @Test
    void testToken() throws Exception {
        User user = new User();
        user.setId("001");
        user.setUsername("jack");
        user.setPassword("123456");

        String token = JwtUtil.create(user.getId());
        System.out.println(token);

        boolean res = JwtUtil.verify(token);
        if (!res) {
            throw new Exception("verify fail");
        }
    }
}