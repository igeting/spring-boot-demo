package com.example.web.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class UserInfo {
    @JsonProperty(value = "id")
    private int id;

    @JsonProperty(value = "username")
    private String username;

    @JsonProperty(value = "password")
    private String password;
}
