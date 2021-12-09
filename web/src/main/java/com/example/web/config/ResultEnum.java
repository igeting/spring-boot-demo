package com.example.web.config;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultEnum {
    SUCCESS(0, "success"),
    ERROR(1, "error");

    private int code;
    private String result;
}
