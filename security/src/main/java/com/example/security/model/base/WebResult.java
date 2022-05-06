package com.example.security.model.base;

import lombok.Data;

@Data
public class WebResult extends BaseResult {
    private String error;
    private String result;
    private String exception;
}
