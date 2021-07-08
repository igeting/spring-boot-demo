package com.example.core.entity.base;

import lombok.Data;

@Data
public class WebResult extends BaseResult {
    private String error;
    private String result;
    private String exception;

    public WebResult() {
    }

    public WebResult(Integer code, String result, String exception) {
        this.setCode(code);
        this.result = result;
        this.exception = exception;
    }
}
