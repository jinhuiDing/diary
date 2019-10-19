package com.ding.diary.service.impl;

import com.ding.diary.dao.UserDiaryRelationDao;
import com.ding.diary.entity.UserDiaryRelation;
import com.ding.diary.service.UserDiaryRelationService;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: UserDiaryRelationServiceImpl
 * @author: ding
 * @date: 2019/10/18 22:05
 * @version: 1.0
 */

@Service
public class UserDiaryRelationServiceImpl  extends BaseServiceImpl<UserDiaryRelation> implements UserDiaryRelationService {

    @Resource
    private UserDiaryRelationDao userDiaryRelationDao;
    @Override
    public Mapper<UserDiaryRelation> getMapper() {
        return userDiaryRelationDao;
    }

    @Override
    public List<Long> queryByUserId(Long id) {

        return userDiaryRelationDao.queryByUserId(id);
    }
}

