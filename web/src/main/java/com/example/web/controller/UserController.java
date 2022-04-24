package com.example.web.controller;

import com.example.web.entity.BaseResult;
import com.example.web.entity.UserInfo;
import com.example.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/getAllUsers")
    public BaseResult getAllUsers() {
        List<UserInfo> allUsers = userService.getAllUsers();
        return BaseResult.success(allUsers);
    }

    @GetMapping(value = "/updateName")
    public BaseResult updateName(HttpServletRequest request) throws Exception {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        if (StringUtils.hasLength(id) && StringUtils.hasLength(name)) {
            userService.updataName(Integer.valueOf(id), name);
            return BaseResult.success(null);
        }
        return BaseResult.fail("param error");
    }
}
