package com.example.jpa.dao;

import com.example.jpa.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<UserInfo, Long> {
}
