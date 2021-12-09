package com.example.web.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class WebResult extends BaseResult {
    private String error;
    private String result;
    private String exception;
}
