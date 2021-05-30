package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    int getUserCount();

    User getUser(int id);

    List<User> getUsers();
}
