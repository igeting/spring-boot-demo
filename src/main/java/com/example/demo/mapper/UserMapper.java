package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    int getUserCount();

    User getUser(int id);

    List<User> getUsers();
}
