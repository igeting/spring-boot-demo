package com.example.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.mybatis.model.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends BaseMapper<UserInfo> {
    @Select(value = "select * from user_info where username = #{name}")
    List<UserInfo> getUsers(String name);

    @Update(value = "update user_info set username = #{name} where id = #{id}")
    int updateUser(@Param("id") String id, @Param("name") String username);

    @Insert(value = "insert into user_info (`username`,`password`) values(#{username}, #{password})")
    int addUser(UserInfo info);

    @Delete(value = "delete from user_info where username = #{name}")
    int delUser(String name);

    UserInfo findUser(long id);
}
