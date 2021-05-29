package com.example.demo.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class User {
    @SerializedName("name")
    private String username;
    @SerializedName("pass")
    private String password;
}
