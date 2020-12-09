package com.zhaocm.test.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.zhaocm.test.po.User;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description:
 * @author: zhaocm
 * @time: 2020/12/3
 */
@Configuration
public class ShiroConfig {

    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }

    @Bean
    public DefaultWebSecurityManager securityManager() {
        // 将自定义 Realm 加进来
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 关联 Realm
        securityManager.setRealm(userRealm());
        return securityManager;
    }

    /**
     * @Author zhaocm
     * @Description 配置Shiro过滤器
     * @Date 2020/12/4
     **/
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
//        定义shiroFactoryBean
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();

//        关联securityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager());

//        自定义登录页面，如果登录的时候，就会执行这个请求，即跳转到登录页
        shiroFilterFactoryBean.setLoginUrl("/toLoginPage");
//        指定陈鳄龟公页面
        shiroFilterFactoryBean.setSuccessUrl("/success");
//        指定为授权界面
        shiroFilterFactoryBean.setUnauthorizedUrl("/unauthorized");

//        设置自定义filter
        Map<String, Filter> filterMap = new LinkedHashMap<>();
        filterMap.put("anyRoleFilter", new MyRolesAAuthorizationFilter());
        shiroFilterFactoryBean.setFilters(filterMap);

//        设置自定义filter.LinkedHashMap 是有序的，进行书序拦截器配置
        Map<String, String> filterChainMap = new LinkedHashMap<>();

//        配置可以匿名访问的地址，可以根据实际情况自己添加，放行一些静态资源等,anno表示放行
        filterChainMap.put("/css/**", "anon");
        filterChainMap.put("/img/**", "anon");
        filterChainMap.put("/js/**", "anon");
//        指定页面放行，例如登录页允许所有人登录
        filterChainMap.put("/toLoginPage", "anon");


//      以"/user/admin/"开头的用户需要身份认证，authc表示要进行身份认证
        filterChainMap.put("/user/demo/**", "authc");

//        页面 -用户需要角色认证
        filterChainMap.put("/levelA/**", "anyRoleFilter[USER,ADMIN,SUPER_ADMIN]");
        filterChainMap.put("/levelB/**", "anyRoleFilter[ADMIN,SUPER_ADMIN]");
        filterChainMap.put("/levelC/**", "anyRoleFilter[SUPER_ADMIN]");

//        /user/admin/ 下的所有请求都需要经过权限认证，只有权限问user：[*]
        filterChainMap.put("/user/admin/**", "perms[user:*]");

//        配置注销过滤器
        filterChainMap.put("/logout", "logout");

//        将mao存入过滤器
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainMap);
        return shiroFilterFactoryBean;
    }

    /**
     * @Author zhaocm
     * @Description 整合thymeleaf
     * @Date 2020/12/4
     * @Param
     **/
    @Bean(name = "shiroDialect")
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }

}
