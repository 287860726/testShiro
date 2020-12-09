package com.zhaocm.test.mapper;

import com.zhaocm.test.po.Permissions;
import com.zhaocm.test.po.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @description:
 * @author: zhaocm
 * @time: 2020/11/26
 */
@Repository
public interface IUserMapper {

    User queryUserByUsername(@Param("username") String username);

    Permissions queryParamermissionByUsername(@Param("username") String username);
}
