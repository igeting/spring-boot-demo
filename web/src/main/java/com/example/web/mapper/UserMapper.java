package com.example.web.mapper;

import com.example.web.entity.UserInfo;

import java.util.List;

public interface UserMapper {
    List<UserInfo> getAllUsers();
    void updataName(int id, String name);
}
