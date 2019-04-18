package com.cs.home234.service;

import com.cs.home234.dao.BaseDao;
import com.cs.home234.utils.PageBean;
import java.util.List;

public class BaseServiceImpl<T> implements  BaseService<T>{
    private BaseDao baseDao;

    public void setBaseDao(BaseDao baseDao) {
        this.baseDao = baseDao;
    }

    @Override
    public T get(Long id) {
        return null;
    }

    @Override
    public T delete(Long id) {
        return null;
    }

    @Override
    public  T update(T entity) {
        return null;
    }

    @Override
    public  T create(T entity) {
        return null;
    }

    @Override
    public PageBean<T> getPageByList(int currentPage, int pageSize) {
        return baseDao.getPageByList(currentPage,pageSize);
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
