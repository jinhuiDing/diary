package com.ding.diary.service.impl;

import com.ding.diary.service.BaseService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @description: BaseServiceImpl
 * @author: ding
 * @date: 2019/10/15 20:55
 * @version: 1.0
 */

public  abstract class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
  public abstract Mapper<T> getMapper();

    @Override
    public T queryById(Object id) {
        return getMapper().selectByPrimaryKey(id);
    }

    @Override
    public List<T> queryAllByLimit(int offset, int limit) {
        PageHelper.startPage(offset, limit);
        return getMapper().selectAll();
    }

    @Override
    public int insert(T t) {
         return getMapper().insert(t);
    }

    @Override
    public int update(T t) {
        return getMapper().updateByPrimaryKeySelective(t);
    }

    @Override
    public boolean deleteById(Object id) {
        return getMapper().deleteByPrimaryKey(id)!=0;
    }
}
