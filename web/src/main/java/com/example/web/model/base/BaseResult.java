package com.example.web.model.base;

import com.example.web.config.ResultEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BaseResult implements Serializable {
    private static final long serialVersionUID = 1L;

    private String message;
    private int code;
    private Object data;

    public static BaseResult success(Object data) {
        return new BaseResult("success", ResultEnum.SUCCESS.getCode(), data);
    }

    public static BaseResult success(Object data, String message) {
        return new BaseResult(message, ResultEnum.SUCCESS.getCode(), data);
    }

    public static BaseResult success(Object data, String message, int code) {
        return new BaseResult(message, code, data);
    }

    public static BaseResult fail(String message) {
        return new BaseResult(message, ResultEnum.FAIL.getCode(), null);
    }

    public static BaseResult fail(String message, int code) {
        return new BaseResult(message, code, null);
    }
}

