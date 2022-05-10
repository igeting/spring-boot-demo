package com.example.web.config;

import com.example.web.model.base.BaseResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public BaseResult exceptionHandle(Exception e, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return BaseResult.fail(bindingResult.getFieldError().getDefaultMessage(), ResultEnum.FAIL.getCode());
        }
        return BaseResult.fail(e.getMessage(), ResultEnum.FAIL.getCode());
    }

    @ExceptionHandler(value = Exception.class)
    public BaseResult exceptionHandle(Exception e) {
        return BaseResult.fail(e.getMessage(), ResultEnum.FAIL.getCode());
    }

    @ExceptionHandler(value = Error.class)
    public BaseResult exceptionHandle(Error e) {
        return BaseResult.fail(e.getMessage(), ResultEnum.FAIL.getCode());
    }
}
