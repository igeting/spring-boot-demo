package com.example.core.model.base;

import lombok.Data;

@Data
public class WebResult extends BaseResult {
    public static final int RESULT_FAIL = 0;
    public static final int RESULT_SUCCESS = 1;

    private String error;
    private String result;
    private String exception;
}
