package com.ding.diary.dao;


import com.ding.diary.entity.SysDiary;
import tk.mybatis.mapper.common.Mapper;

/**
 * (SysDiary)表数据库访问层
 *
 * @author makejava
 * @since 2019-10-15 20:52:40
 */
@org.apache.ibatis.annotations.Mapper
public interface SysDiaryDao extends Mapper<SysDiary> {


}