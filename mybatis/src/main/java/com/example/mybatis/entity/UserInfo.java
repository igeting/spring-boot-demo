package com.example.mybatis.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@TableName(value = "${prefix}user_info")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo extends BaseModel {

    @JsonProperty(value = "username")
    @TableField(value = "username")
    private String username;

    @JsonProperty(value = "password")
    @TableField(value = "password")
    private String password;
}
