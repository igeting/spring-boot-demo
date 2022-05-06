package com.example.web.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.example.web.model.base.BaseModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class UserInfo extends BaseModel {

    @TableField(value = "username")
    @SerializedName(value = "username")
    private String username;

    @TableField(value = "password")
    @SerializedName(value = "password")
    private String password;
}
