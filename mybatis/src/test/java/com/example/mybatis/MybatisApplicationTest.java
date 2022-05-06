package com.example.mybatis;

import com.example.mybatis.model.UserInfo;
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
        List<UserInfo> users = userService.selectList();
        users.forEach(System.out::println);
    }
}
