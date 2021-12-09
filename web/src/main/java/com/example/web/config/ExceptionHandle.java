package com.example.web.config;

import com.example.web.entity.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    public BaseResult exceptionHandler(Exception e) {
        log.error("ERROR:", e);
        return new BaseResult(ResultEnum.ERROR.getCode(), e.getMessage());
    }
}
