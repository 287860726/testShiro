package com.zhaocm.test.config;

import com.zhaocm.test.po.User;
import com.zhaocm.test.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * @param principalCollection
     * @Author zhaocm
     * @Description 授权
     * @Date 2020/12/3
     * @Param
     **/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        // 获取用户名信息
        String username = (String) principalCollection.getPrimaryPrincipal();
        //创建一个简单授权验证信息
        // 创建一个简单授权验证信息
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // 给这个用户设置从 role 表获取到的角色信息
        authorizationInfo.addRole(userService.queryUserByUsername(username).getRole().getRoleName());
        //给这个用户设置从permission表中获取的权限信息
        authorizationInfo.addStringPermission(userService.queryPermissionByUsername(username).getPermissionName());
        return authorizationInfo;
    }

    /**
     * @param authenticationToken
     * @return org.apache.shiro.authc.AuthenticationInfo
     * @Author zhaocm
     * @Description 认证
     * @Date 2020/12/3
     * @Param
     **/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
//        根据在接收前台数据创建的Token获取用户名
        String username = (String) authenticationToken.getPrincipal();
//        通过用户名查询相关的用户信息（实体）
        User user = userService.queryUserByUsername(username);
        if (null != user) {
//            存入Session ,可选
            SecurityUtils.getSubject().getSession().setAttribute("user", user);
//            密码认证工作，shiro来做
            AuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo();
            return authenticationInfo;
        } else {
            return null;
        }
    }
}
