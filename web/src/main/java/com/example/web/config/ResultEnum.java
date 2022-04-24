package com.example.web.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultEnum {
    SUCCESS(0, "success"),
    FAIL(1, "fail"),
    ;

    private int code;
    private String value;
}
