package com.example.swagger.controller;

import com.example.swagger.dto.UserDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;


@Api(tags = "user controller")
@RequestMapping(value = "/user")
@RestController
public class UserController {

    @ApiOperation(value = "add user interface")
    @PostMapping(value = "/user")
    public UserDTO addUser() {
        return new UserDTO();
    }

    @ApiOperation(value = "del user interface")
    @DeleteMapping(value = "/user")
    public UserDTO delUser(@RequestBody UserDTO user) {
        return user;
    }

    @ApiOperation(value = "mod user interface")
    @PutMapping(value = "/user")
    public UserDTO modUser(@RequestBody UserDTO user) {
        return user;
    }

    @ApiOperation(value = "get user interface")
    @GetMapping(value = "/user")
    public UserDTO getUser() {
        return new UserDTO();
    }
}
