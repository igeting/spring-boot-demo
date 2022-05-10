package com.example.web.to;


import com.google.gson.annotations.SerializedName;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class UserTO {
    @NotBlank(message = "username not empty")
    @SerializedName(value = "username")
    private String username;

    @NotBlank(message = "password not empty")
    @SerializedName(value = "password")
    private String password;
}
