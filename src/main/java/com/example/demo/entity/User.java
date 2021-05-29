package com.example.demo.entity;

import com.example.demo.entity.base.Base;
import lombok.Data;

@Data
public class User extends Base {
    private String username;
    private String password;
}
