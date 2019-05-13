package com.cs.home234.controller;

import com.cs.home234.Entity.User;
import com.cs.home234.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

@Controller
@RequestMapping("api/login")
public class LoginController {
    @Autowired
    private LoginService loginService;
    @RequestMapping(value = "/getLogin",method = RequestMethod.GET)
    public ModelAndView getLogin(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("login");
        return mv;
    }
    @RequestMapping(value = "/getRegister",method = RequestMethod.GET)
    public ModelAndView getRegister(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("register");
        return mv;
    }
    /**
     * @Author LH
     * @Description //注册时的逻辑
     * @Date 12:44 2019/5/13
     * @Param [req]
     * @return org.springframework.web.servlet.ModelAndView
     **/
    @RequestMapping(value = "/register")
    public ModelAndView register(HttpServletRequest req,String image1,String userName,String password){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("login");
        User u=new User();
        u.setPassword(password);
        u.setUserName(userName);
        Random r=new Random();
        int i = r.nextInt(4) + 1;
        u.setUid(String.valueOf(i));
        if(image1==null){
            req.setAttribute("msg","验证码不能为空");
            return mv;
        }
        String image = (String)req.getSession().getAttribute("image");
        if(!image1.equalsIgnoreCase(image)){
            req.setAttribute("msg","验证码错误");
            return mv;
        }
        User user = loginService.register(u);
        mv.addObject("user",user);
        return mv;
    }
    @RequestMapping(value = "/login")
    public ModelAndView login(HttpServletRequest req,String image1,String userName,String password){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("listUI");
        if(image1==null){
            req.setAttribute("msg","验证码不能为空");
            return mv;
        }
        String image = (String)req.getSession().getAttribute("image");
        if(!image1.equalsIgnoreCase(image)){
            req.setAttribute("msg","验证码错误");
            return mv;
        }
        try {
            User user = loginService.login(userName, password);
        } catch (Exception e) {
            req.setAttribute("msg",e.getMessage());
        }
        return mv;
    }

    @RequestMapping(value = "/getListUI",method = RequestMethod.GET)
    public ModelAndView getListUI(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("listUI");
        return mv;
    }

}
