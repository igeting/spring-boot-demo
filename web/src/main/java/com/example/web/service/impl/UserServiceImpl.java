package com.example.web.service.impl;

import com.example.web.entity.User;
import com.example.web.mapper.UserMapper;
import com.example.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(propagation = Propagation.REQUIRED, timeout = 30, rollbackFor = Exception.class)
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getAllUsers() {
        return userMapper.getAllUsers();
    }

    @Override
    public void updataName(int id, String name) throws Exception{
        userMapper.updataName(id, name);
        throw new Exception("this is exception");
    }
}
