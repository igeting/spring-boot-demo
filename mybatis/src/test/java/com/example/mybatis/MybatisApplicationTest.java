package com.example.mybatis;

import com.example.mybatis.entity.User;
import com.example.mybatis.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MybatisApplicationTest {
    @Autowired
    private UserService userService;

    @Test
    public void TestMybatis() {
        List<User> users = userService.selectList();
        users.forEach(System.out::println);
    }
}
