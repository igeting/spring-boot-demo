package com.example.web.entity;

import com.example.web.config.ResultEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class BaseResult extends Basic {
    private Integer code;
    private String message;
    private Object data;
    private Object other;

    public BaseResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseResult(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static BaseResult error(String err) {
        return new BaseResult(ResultEnum.ERROR.getCode(), err);
    }

    public static BaseResult success(Object data) {
        return new BaseResult(ResultEnum.SUCCESS.getCode(), ResultEnum.SUCCESS.getResult(), data);
    }
}

