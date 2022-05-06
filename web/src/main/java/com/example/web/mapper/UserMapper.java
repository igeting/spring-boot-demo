package com.example.web.mapper;

import com.example.web.model.UserInfo;

import java.util.List;

public interface UserMapper {
    List<UserInfo> getUsers();

    UserInfo getUser(Long id);

    int updateUser(UserInfo info);
}
