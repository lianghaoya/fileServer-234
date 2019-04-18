package com.cs.home234.controller;

import com.cs.home234.Entity.User;
import com.cs.home234.service.LoginService;
import com.cs.home234.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api/login")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @RequestMapping("/userLogin")
    @ResponseBody
    public PageBean<User> TestLogin(){
        return loginService.getPageByList(1,10);
    }
}
