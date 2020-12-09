package com.zhaocm.test.ctrl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageCtrl {

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/about")
    public String toAboutPage(){
        return "redirect:http://www.baidu.com";
    }

    @RequestMapping("/toLoginPage")
    public String toLoginPage(){
        return "views/login";
    }

    @RequestMapping("/levelA/{name}")
    public String toLevelAPage(@PathVariable("name") String name){
        return "views/L-A" + name;
    }

    @RequestMapping("/levelB/{name}")
    public String toLevelBPage(@PathVariable("name") String name){
        return "views/L-B" + name;
    }

    @RequestMapping("/levelC/{name}")
    public String toLevelCPage(@PathVariable("name") String name){
        return "views/L-C" + name;
    }

    @RequestMapping("/unauthorized")
    public String toUnanthorizedPage(){
        return "views/unauthorized";
    }

    @RequestMapping("/success")
    public String toSuccessPage(){
        return "views/success";
    }

}
