package com.cs.home234.dao;

import com.cs.home234.utils.PageBean;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

public class BaseDaoImpl<T> implements BaseDao<T>{
    @Autowired
    protected SqlSessionFactory sessionFactory;
    //获取session 开启事务 对数据库进行操作
    protected SqlSession getSession(){
        return sessionFactory.openSession();
    }
    @Override
    public T get(Long id) {
        T t=(T)getSession().selectOne("com.cs.home234.Entity.User",id);
        return t;
    }

    @Override
    public T delete(Long id) {
        return null;
    }

    @Override
    public T update(T entity) {
        return null;
    }

    @Override
    public T create(T entity) {
        return null;
    }

    @Override
    public PageBean<T> getPageByList(int currentPage, int pageSize) {
        //这里将调用session 和 数据库交互 这里我只测试了一下框架是否连通
        PageBean test=new PageBean();
        test.setPage(100);
        test.setPageSize(150);
        return test;
    }

    @Override
    public int deleteByIds(List ids) {
        return 0;
    }

    @Override
    public T get(String userName) {
        return null;
    }
}
