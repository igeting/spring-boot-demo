package com.example.core.service.impl;

import com.example.core.entity.User;
import com.example.core.mapper.UserMapper;
import com.example.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public int getUserCount() {
        return userMapper.getUserCount();
    }

    @Override
    public User getUser(int id) {
        return userMapper.getUser(id);
    }

    @Override
    public List<User> getUsers() {
        return userMapper.getUsers();
    }
}
