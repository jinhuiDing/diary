package com.ding.diary.dao;

import com.ding.diary.entity.UserDiaryRelation;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @description: UserDiaryRelationDao
 * @author: ding
 * @date: 2019/10/18 22:07
 * @version: 1.0
 */
@org.apache.ibatis.annotations.Mapper
public interface UserDiaryRelationDao extends Mapper<UserDiaryRelation> {
    List<Long> queryByUserId(@Param("id") Long id);
}
