package com.zhaocm.test.ctrl;

import com.zhaocm.test.po.User;
import com.zhaocm.test.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserCtrl {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/demo/user")
    private User queryUserByUsername(){
        return userService.queryUserByUsername("BWH_Steven");
    }

    @RequestMapping("login")
    private String login(String username, String password, HttpServletRequest request){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            request.getSession().setAttribute("user",user);
            return "views/success";
        }catch (Exception e){
            e.printStackTrace();
            request.getSession().setAttribute("user",user);
            request.setAttribute("errorMsg", "兄弟，用户名或密码错误。");
            return "views/login";
        }
    }

}
