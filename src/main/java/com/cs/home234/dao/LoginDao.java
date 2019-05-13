package com.cs.home234.dao;

import com.cs.home234.Entity.User;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class LoginDao extends BaseDaoImpl<User>{
    @Override
    public User get(String userName) {
        User u=getSession().selectOne("com.cs.home234.Entity.User.getById",userName);
        return u;
    }
    public User register(User u){
        getSession().insert("com.cs.home234.Entity.User.insert",u);
        return u;
    }
}
