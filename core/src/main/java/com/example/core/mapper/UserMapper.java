package com.example.core.mapper;

import com.example.core.entity.User;

import java.util.List;

public interface UserMapper {
    int getUserCount();

    User getUser(int id);

    List<User> getUsers();
}
