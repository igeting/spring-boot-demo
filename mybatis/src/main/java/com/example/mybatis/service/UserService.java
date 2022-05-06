package com.example.mybatis.service;

import com.example.mybatis.model.UserInfo;
import com.example.mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<UserInfo> selectList() {
        List<UserInfo> users = userMapper.selectList(null);
        return users;
    }
}
