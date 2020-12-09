package com.zhaocm.test.service.impl;

import com.zhaocm.test.mapper.IUserMapper;
import com.zhaocm.test.po.Permissions;
import com.zhaocm.test.po.User;
import com.zhaocm.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: zhaocm
 * @time: 2020/11/26
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private IUserMapper userMapper;

    @Override
    public User queryUserByUsername(String username) {
        return userMapper.queryUserByUsername(username);
    }

    @Override
    public Permissions queryPermissionByUsername(String username) {
        return userMapper.queryParamermissionByUsername(username);
    }
}
