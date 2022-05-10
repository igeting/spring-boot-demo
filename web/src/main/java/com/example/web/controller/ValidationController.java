package com.example.web.controller;

import com.example.web.to.ValidationTO;
import com.example.web.model.base.BaseResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/${app.version}")
public class ValidationController {

    @PostMapping(value = "/valid")
    public BaseResult valid(@Validated @RequestBody ValidationTO info) {
        return BaseResult.success(info);
    }
}
