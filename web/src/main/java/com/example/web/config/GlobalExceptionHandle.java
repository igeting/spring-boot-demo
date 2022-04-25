package com.example.web.config;

import com.example.web.entity.BaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandle {

    @ExceptionHandler(value = Exception.class)
    public BaseResult exceptionHandle(Exception e) {
        log.error("ExceptionHandle:{}", e.getMessage(), e);
        return BaseResult.fail(e.getMessage(), ResultEnum.FAIL.getCode());
    }
}
