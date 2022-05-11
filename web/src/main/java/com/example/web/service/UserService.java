package com.example.web.service;

import com.example.web.to.UserTO;
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
        return BeanUtil.transList(userMapper.getUsers(), UserVO.class);
    }

    public UserVO getUser(Long id) {
        return BeanUtil.trans(userMapper.getUser(id), UserVO.class);
    }

    public void modUser(Long id, UserTO dto) {
        UserInfo info = BeanUtil.trans(dto, UserInfo.class);
        info.setId(id);
        int count = userMapper.modUser(info);
        if (count == 0) {
            throw new RuntimeException("update exception");
        }
    }
}
