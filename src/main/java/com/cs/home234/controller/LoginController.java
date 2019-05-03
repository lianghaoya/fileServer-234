package com.cs.home234.controller;

import com.cs.home234.Entity.User;
import com.cs.home234.service.LoginService;
import com.cs.home234.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("api/login")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @RequestMapping(value = "/userLogin",method = RequestMethod.GET)
    @ResponseBody
    public PageBean<User> getLogin(String id){
        User user=loginService.get(id);
        //封装数据
        PageBean bean=new PageBean();
        List list=new ArrayList();
        list.add(user);
        bean.setData(list);

        return bean;
    }
}
