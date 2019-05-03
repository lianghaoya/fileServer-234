package com.cs.home234.dao;

import com.cs.home234.Entity.User;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;

@Repository
public class LoginDao extends BaseDaoImpl<User>{
    @Override
    public User get(String id) {
        User u=getSession().selectOne("com.cs.home234.Entity.User.getById",id);
        return u;
    }
}
