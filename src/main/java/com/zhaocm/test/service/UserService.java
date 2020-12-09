package com.zhaocm.test.service;

import com.zhaocm.test.po.Permissions;
import com.zhaocm.test.po.User;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: zhaocm
 * @time: 2020/11/26
 */
@Service
public interface UserService {

    public User queryUserByUsername(String username);

    public Permissions queryPermissionByUsername(String username);
}
