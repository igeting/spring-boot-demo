package com.example.core.config;

import com.example.core.entity.base.BaseResult;
import com.example.core.entity.base.WebResult;
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
    public BaseResult globalException(HttpServletRequest request, HttpServletResponse response, NullPointerException e) {
        log.info("GlobalExceptionHandler handler, code:{}", response.getStatus());
        BaseResult result = new WebResult(WebResult.RESULT_FAIL, "result:" + response.getStatus(),
                "exception:" + e.getMessage()
        );
        return result;
    }
}
