package com.ding.diary.service;

import com.ding.diary.entity.UserDiaryRelation;

import java.util.List;

/**
 * (UserDiaryRelation)表服务接口
 *
 * @author makejava
 * @since 2019-10-18 21:40:12
 */
public interface UserDiaryRelationService extends  BaseService<UserDiaryRelation> {


    List<Long> queryByUserId(Long id);
}