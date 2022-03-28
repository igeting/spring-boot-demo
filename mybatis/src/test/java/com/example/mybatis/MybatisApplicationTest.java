package com.example.mybatis;

import com.example.mybatis.entity.User;
import com.example.mybatis.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MybatisApplicationTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void TestMybatis() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
}
