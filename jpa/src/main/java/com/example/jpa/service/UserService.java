package com.example.jpa.service;

import com.example.jpa.dao.UserDao;
import com.example.jpa.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public UserInfo addUser(UserInfo info) {
        return userDao.save(info);
    }

    public void delUser(Long id) {
        userDao.deleteById(id);
    }

    public UserInfo updateUser(UserInfo info) {
        return userDao.save(info);
    }

    public List<UserInfo> findAllUsers() {
        return userDao.findAll();
    }

    public UserInfo findUserById(Long id) {
        return userDao.findById(id).orElse(null);
    }
}
