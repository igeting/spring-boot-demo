package com.example.jpa.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "user_info")
public class UserInfo extends BaseModel {
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;
}










