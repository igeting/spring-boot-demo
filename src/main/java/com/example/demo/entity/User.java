package com.example.demo.entity;

import com.example.demo.entity.base.Base;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class User extends Base {
    @SerializedName("name")
    private String username;
    @SerializedName("pass")
    private String password;
}
