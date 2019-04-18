package com.cs.home234.service;

import com.cs.home234.Entity.User;
import com.cs.home234.dao.LoginDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService extends BaseServiceImpl<User>{
    private LoginDao loginDao;

    public LoginDao getLoginDao() {
        return loginDao;
    }
    @Autowired
    public void setLoginDao(LoginDao loginDao) {
        super.setBaseDao(loginDao);
        this.loginDao = loginDao;
    }
}
