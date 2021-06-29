package com.example.core.service;

import com.example.core.entity.User;

import java.util.List;

public interface UserService {
    int getUserCount();

    User getUser(int id);

    List<User> getUsers();
}
