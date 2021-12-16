package com.example.web.service;

import com.example.web.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void updataName(int id, String name) throws Exception;
}
