package com.example.core.entity.base;

import lombok.Data;

@Data
public class WebResult extends BaseResult {
    private String error;
    private String result;
    private String exception;
}
