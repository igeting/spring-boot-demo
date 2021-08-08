package com.example.web.controller;

import com.example.web.entity.BaseResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@RestController
public class TestController {

    @RequestMapping(value = "/test")
    public BaseResult test(HttpServletRequest request) throws Exception {
        String name = request.getParameter("name");
        if (Objects.isNull(name)) {
            throw new Exception("name is empty");
        }
        return new BaseResult(200, "success", name);
    }
}
