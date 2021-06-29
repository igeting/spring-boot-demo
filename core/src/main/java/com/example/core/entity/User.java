package com.example.core.entity;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "username")
    @SerializedName(value = "name")
    private String username;

    @Column(name = "password")
    @SerializedName(value = "pass")
    private String password;
}
