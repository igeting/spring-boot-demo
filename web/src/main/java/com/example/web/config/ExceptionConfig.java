package com.example.web.config;

import com.example.web.entity.BaseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@RestControllerAdvice
public class ExceptionConfig {

    @ExceptionHandler(value = Exception.class)
    public BaseResult exceptionHandler(Exception e) {
        if (e instanceof IOException) {
            return new BaseResult(ResultEnum.ERROR.getCode(), e.getMessage());
        }
        return new BaseResult(ResultEnum.ERROR.getCode(), e.getMessage());
    }
}
