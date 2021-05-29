package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserMapper {
    int userCount();

    List<User> userList();
}
