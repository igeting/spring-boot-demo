package com.example.core.entity.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResult implements Serializable {
    private static final long serialVersionUID = 1L;

    private String message;
    private int code;
    private Object data;

    public static BaseResult success(Object data) {
        return new BaseResult("success", HttpStatus.OK.value(), data);
    }

    public static BaseResult success(Object data, String message) {
        return new BaseResult(message, HttpStatus.OK.value(), data);
    }

    public static BaseResult success(Object data, String message, int code) {
        return new BaseResult(message, code, data);
    }

    public static BaseResult fail(String message) {
        return new BaseResult(message, HttpStatus.BAD_REQUEST.value(), null);
    }

    public static BaseResult fail(String message, int code) {
        return new BaseResult(message, code, null);
    }
}
