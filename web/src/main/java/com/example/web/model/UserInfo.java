package com.example.web.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.example.web.model.base.BaseModel;
import lombok.Data;
import lombok.ToString;

@TableName(value = "user_info", keepGlobalPrefix = true)
@Data
@ToString
public class UserInfo extends BaseModel {

    @TableField(value = "username")
    private String username;

    @TableField(value = "password")
    private String password;
}
