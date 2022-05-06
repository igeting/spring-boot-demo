package com.example.web.config;

import com.example.web.model.base.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    public BaseResult exceptionHandle(Exception e, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return BaseResult.fail(bindingResult.getFieldError().getDefaultMessage(), ResultEnum.FAIL.getCode());
        }
        log.error("ExceptionHandle:{}", e.getMessage(), e);
        return BaseResult.fail(e.getMessage(), ResultEnum.FAIL.getCode());
    }
}
