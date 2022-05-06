package com.example.web.controller;

import com.example.web.config.ResultEnum;
import com.example.web.model.base.BaseResult;
import com.example.web.model.ValidationInfo;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/valid")
public class ValidationController {

    public BaseResult valid(@Validated @RequestBody ValidationInfo info, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return BaseResult.fail(bindingResult.getFieldError().getDefaultMessage(), ResultEnum.FAIL.getCode());
        }

        return BaseResult.success(info);
    }
}
