package com.ding.diary.service;

import java.util.List;

/**
 * @description: BaseService
 * @author: ding
 * @date: 2019/10/15 20:54
 * @version: 1.0
 */
public interface BaseService<T> {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    T queryById(Object id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<T> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sysDiary 实例对象
     * @return 实例对象
     */
    int insert(T t);

    /**
     * 修改数据
     *
     * @param sysDiary 实例对象
     * @return 实例对象
     */
    int update(T t);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Object id);
}
