package com.cs.home234.dao;

import com.cs.home234.utils.PageBean;

import java.util.List;

public interface BaseDao<T> {
    T get(Long id);
    T delete(Long id);
    T update(T entity);
    T create(T entity);
    PageBean<T> getPageByList(int currentPage,int pageSize);
    int deleteByIds(List ids);
    T get(String userName);
}
