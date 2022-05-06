package com.example.core.mapper;

import com.example.core.model.UserInfo;
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
public interface UserMapper extends JpaRepository<UserInfo, Long> {
    @Query(value = "select * from user", nativeQuery = true)
    List<UserInfo> allUsers();

    @Query(value = "select * from user where username = ?", nativeQuery = true)
    List<UserInfo> getByName(String name);

    int getUserCount();

    UserInfo getUser(int id);

    List<UserInfo> getUsers();
}
