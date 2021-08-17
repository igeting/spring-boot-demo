package com.example.web.entity;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class WebParam extends BaseParam {

    @NotBlank(message = "system id not blank")
    private String systemId;
}
