package com.example.web.service;

import com.example.web.entity.UserInfo;

import java.util.List;

public interface UserService {
    List<UserInfo> getAllUsers();

    void updataName(int id, String name) throws Exception;
}
