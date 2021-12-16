package com.example.web.mapper;

import com.example.web.entity.User;

import java.util.List;

public interface UserMapper {
    List<User> getAllUsers();
    void updataName(int id, String name);
}
