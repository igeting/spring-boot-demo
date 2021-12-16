package com.example.web.controller;

import com.example.web.entity.BaseResult;
import com.example.web.entity.User;
import com.example.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/getAllUsers")
    public BaseResult getAllUsers() {
        List<User> allUsers = userService.getAllUsers();
        return BaseResult.success(allUsers);
    }
}
