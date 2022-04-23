package com.example.mybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "user_info")
public class UserInfo {
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
    private String username;
    private String password;
}
