package com.wkk.controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wkk
 * @date 2021/4/1 17:39
 */
@Controller
public class PageController {
    @RequestMapping("/toRegister")
    public String toRegister(){
        return "register";
    }

    @RequestMapping("/toUserInfo")
    public String toUserInfo(){
        return "shop/user-info";
    }

    @RequestMapping("/toIndex")
    public String toIndex( ){
        return "shop/index";
    }

    @RequestMapping("/MyAccount")
    public String toMyAccount(){
        return "shop/my-account";
    }

    @RequestMapping("/toTraceInfo")
    public String toTraceInfo(){
        return "shop/trace-info";
    }
}
