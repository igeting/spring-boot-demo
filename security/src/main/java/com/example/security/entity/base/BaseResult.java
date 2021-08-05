package com.example.security.entity.base;

import lombok.Data;

@Data
public class BaseResult extends Basic {
    public static final int RESULT_FAIL = 0;
    public static final int RESULT_SUCCESS = 1;

    private Integer code;
    private String message;
    private Object data;
    private Object other;

    public BaseResult() {
    }

    public BaseResult(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseResult(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static BaseResult success(Object data){
        BaseResult result = new BaseResult(200, "success");
        result.setData(data);
        return result;
    }

    public static BaseResult success(Object data, Object other){
        BaseResult result = new BaseResult(200, "success");
        result.setData(data);
        result.setOther(other);
        return result;
    }
}
