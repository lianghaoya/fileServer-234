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

    @Override
    public User get(String id) {
        return loginDao.get(id);
    }

    public User register(User u){
        User user=loginDao.register(u);
        return user;
    }
    public User login(String userName,String password) throws Exception{
        User user=loginDao.get(userName);
        if (user==null)
            throw new Exception("用户名错误");
        if(!user.getPassword().equals(password))
            throw new Exception("密码错误");
        return user;
    }

}
