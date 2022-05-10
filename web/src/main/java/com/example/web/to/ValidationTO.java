package com.example.web.to;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class ValidationTO {

    @NotNull(message = "username not empty")
    private String username;

    @Max(value = 100, message = "max age is 100")
    @Min(value = 0, message = "min age is 0")
    private int age;
}
