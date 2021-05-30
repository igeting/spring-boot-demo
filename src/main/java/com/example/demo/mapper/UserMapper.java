package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 如果指定了@MapperScan(value = {"com.example.demo.mapper"}) 可以省略@Mapper
 */
@Mapper
public interface UserMapper {
    int getUserCount();

    User getUser(int id);

    List<User> getUsers();
}
