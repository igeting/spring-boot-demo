package com.example.web.controller;

import com.example.web.to.UserTO;
import com.example.web.model.base.BaseResult;
import com.example.web.service.UserService;
import com.example.web.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(value = "/api/${app.version}")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user")
    public BaseResult getUsers() {
        List<UserVO> allUsers = userService.getUsers();
        return BaseResult.success(allUsers);
    }

    @GetMapping(value = "/user/{id}")
    public BaseResult getUser(@PathVariable(value = "id") Long id) {
        UserVO user = userService.getUser(id);
        return BaseResult.success(user);
    }

    @PutMapping(value = "/user/{id}")
    public BaseResult updateUser(@PathVariable(value = "id") Long id, @RequestBody UserTO dto) {
        if (Objects.nonNull(dto)) {
            userService.modUser(id, dto);
            return BaseResult.success(null);
        }
        return BaseResult.fail("param error");
    }
}
