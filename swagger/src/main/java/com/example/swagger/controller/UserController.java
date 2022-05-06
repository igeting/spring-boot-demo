package com.example.swagger.controller;

import com.example.swagger.dto.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


@Api(tags = "user api")
@RequestMapping(value = "/user")
@RestController
public class UserController {

    @ApiOperation(value = "add user")
    @PostMapping(value = "/user")
    public UserDTO addUser() {
        return new UserDTO();
    }

    @ApiOperation(value = "del user")
    @DeleteMapping(value = "/user")
    public UserDTO delUser(@RequestBody UserDTO user) {
        return user;
    }

    @ApiOperation(value = "mod user")
    @PutMapping(value = "/user")
    public UserDTO modUser(@RequestBody UserDTO user) {
        return user;
    }

    @ApiOperation(value = "get user")
    @GetMapping(value = "/user")
    public UserDTO getUser() {
        return new UserDTO();
    }
}
