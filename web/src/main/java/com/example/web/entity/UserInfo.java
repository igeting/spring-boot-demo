package com.example.web.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class UserInfo extends BaseEntity {

    @TableField(value = "username")
    @SerializedName(value = "username")
    private String username;

    @TableField(value = "password")
    @SerializedName(value = "password")
    private String password;
}
