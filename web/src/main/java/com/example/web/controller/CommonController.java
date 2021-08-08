package com.example.web.controller;

import com.example.web.entity.BaseResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@RestControllerAdvice
public class CommonController {

    @ExceptionHandler(value = Exception.class)
    public BaseResult exceptionHandler(Exception e) {
        if (e instanceof IOException) {
            return new BaseResult(500, "io exception");
        }
        return new BaseResult(500, e.getMessage());
    }
}
