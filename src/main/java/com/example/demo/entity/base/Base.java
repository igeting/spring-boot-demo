package com.example.demo.entity.base;

import lombok.Data;

import java.io.Serializable;

@Data
public class Base implements Serializable {
    private int code;
    private String message;
    private Object data;
    private Object other;
}
