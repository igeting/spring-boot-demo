package com.example.web.service;

import com.example.web.dto.UserDTO;
import com.example.web.model.UserInfo;
import com.example.web.mapper.UserMapper;
import com.example.web.util.BeanUtil;
import com.example.web.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, timeout = 30, rollbackFor = RuntimeException.class)
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public List<UserVO> getUsers() {
        return BeanUtil.convertList(userMapper.getUsers(), UserVO.class);
    }

    public UserVO getUser(Long id) {
        return BeanUtil.convertBean(userMapper.getUser(id), UserVO.class);
    }

    public void updateUser(UserDTO dto) {
        UserInfo info = BeanUtil.convertBean(dto, UserInfo.class);
        int count = userMapper.updateUser(info);
        if (count == 0) {
            throw new RuntimeException("update exception");
        }
    }
}
