package com.example.web.controller;

import com.example.web.dto.ValidationDTO;
import com.example.web.model.base.BaseResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1")
public class ValidationController {

    @PostMapping(value = "/valid")
    public BaseResult valid(@Validated @RequestBody ValidationDTO info) {
        return BaseResult.success(info);
    }
}
