package com.example.web.dto;


import com.example.web.entity.UserInfo;
import org.springframework.beans.BeanUtils;

public class UserDTO implements Converter<UserDTO, UserInfo> {
    private String username;
    private String password;

    @Override
    public UserInfo convertEnt(UserDTO userDTO) {
        UserInfo info = new UserInfo();
        BeanUtils.copyProperties(userDTO, info);
        return info;
    }

    @Override
    public UserDTO convertDto(UserInfo s) {
        UserDTO dto = new UserDTO();
        BeanUtils.copyProperties(this, dto);
        return dto;
    }
}
