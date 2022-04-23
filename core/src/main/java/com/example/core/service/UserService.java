package com.example.core.service;

import com.example.core.entity.UserInfo;

import java.util.List;

public interface UserService {
    int getUserCount();

    UserInfo getUser(int id);

    List<UserInfo> getUsers();
}
