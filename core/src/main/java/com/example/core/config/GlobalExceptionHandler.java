package com.example.core.config;

import com.example.core.model.base.WebResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(value = NullPointerException.class)
    public WebResult globalException(HttpServletRequest request, HttpServletResponse response, NullPointerException e) {
        log.info("GlobalExceptionHandler...");
        WebResult result = new WebResult();
        result.setCode(WebResult.RESULT_FAIL);
        result.setMessage("null point exception:" + e.getMessage());
        return result;
    }

}
