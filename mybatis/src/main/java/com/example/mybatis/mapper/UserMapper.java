package com.example.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatis.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

//@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select(value = "select * from user_info where username = #{name}")
    List<User> getUsers(String name);

    @Update(value = "update user_info set username = #{name} where id = #{id}")
    int updateUser(@Param("id") String id, @Param("name") String username);

    @Insert(value = "insert into user_info (`username`,`password`) values(#{username}, #{password})")
    int addUser(User user);

    @Delete(value = "delete from user_info where username = #{name}")
    int delUser(String name);

    User findUser(long id);
}
