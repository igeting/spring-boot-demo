package com.example.jpa.controller;

import com.example.jpa.model.UserInfo;
import com.example.jpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "")
    public UserInfo addUser(@RequestBody UserInfo info) {
        return userService.addUser(info);
    }

    @DeleteMapping(value = "/{id}")
    public void delUser(@PathVariable("id") Long id) {
        userService.delUser(id);
    }

    @PutMapping(value = "")
    public UserInfo updateUser(@RequestBody UserInfo info) {
        return userService.updateUser(info);
    }

    @GetMapping(value = "")
    public List<UserInfo> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping(value = "/{id}")
    public UserInfo findUserById(@PathVariable("id") Long id) {
        return userService.findUserById(id);
    }

}
