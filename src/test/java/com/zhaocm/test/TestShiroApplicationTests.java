package com.zhaocm.test;

import com.zhaocm.test.mapper.IUserMapper;
import com.zhaocm.test.po.Permissions;
import com.zhaocm.test.po.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestShiroApplicationTests {

    @Autowired
    private IUserMapper userMapper;

    @Test
    void contextLoads() {
        User user = userMapper.queryUserByUsername("admin");
        System.out.println(user.toString());
        Permissions permissions = userMapper.queryParamermissionByUsername("admin");
        System.out.println(permissions.toString());
    }

}
