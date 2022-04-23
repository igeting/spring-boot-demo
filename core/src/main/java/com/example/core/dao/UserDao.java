package com.example.core.dao;

import com.example.core.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/*
 1、Repository
 2、CrudRepository
 3、PagingAndSortingRepository
 4、JpaRepository
 5、JPASpecificationExecutor
 */

/**
 * User 当前映射的实体
 * Integer 当前实体主键类型
 */
public interface UserDao extends JpaRepository<User, Long> {
    @Query(value = "select * from user", nativeQuery = true)
    List<User> allUsers();

    @Query(value = "select * from user where username = ?", nativeQuery = true)
    List<User> getByName(String name);
}
