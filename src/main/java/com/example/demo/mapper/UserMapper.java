package com.example.demo.mapper;

import com.example.demo.entity.User;

import java.util.List;

public interface UserMapper {
    int getUserCount();

    User getUser(int id);

    List<User> getUsers();
}
