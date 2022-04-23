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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "username")
    @SerializedName(value = "name")
    private String username;

    @Column(name = "password")
    @SerializedName(value = "pass")
    private String password;
}
