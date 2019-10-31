package com.ding.diary.service.impl;

import com.ding.diary.dao.SysDiaryDao;
import com.ding.diary.entity.LoginUser;
import com.ding.diary.entity.SysDiary;
import com.ding.diary.entity.UserDiaryRelation;
import com.ding.diary.exception.CustomException;
import com.ding.diary.interceptor.LoginInterceptor;
import com.ding.diary.service.SysDiaryService;
import com.ding.diary.service.UserDiaryRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * (SysDiary)表服务实现类
 *
 * @author makejava
 * @since 2019-10-15 20:52:41
 */
@Service("sysDiaryService")
public class SysDiaryServiceImpl extends BaseServiceImpl<SysDiary> implements SysDiaryService {
    @Resource
    private SysDiaryDao sysDiaryDao;
    @Autowired
    private UserDiaryRelationService userDiaryRelationService;


    @Override
    public Mapper<SysDiary> getMapper() {
        return sysDiaryDao;
    }

    @Override
    @Transactional
    public Boolean insert(String content, String place) {
        //保存内容
        SysDiary diary = new SysDiary();
        diary.setContent(content);
        diary.setPlace(place);
        Date date = new Date();
        System.out.println("date = " + date);
        diary.setCreateTime(date);
        int diaryInsert = this.sysDiaryDao.insertSelective(diary);
        //保存中间表
        LoginUser user = LoginInterceptor.getUser();
        UserDiaryRelation userDiaryRelation = new UserDiaryRelation(user.getId(), diary.getId());
        int insert = this.userDiaryRelationService.insert(userDiaryRelation);
        if (insert == 0 || diaryInsert == 0) {
            throw new CustomException("记录信息失败");
        }
        return true;
    }

    @Override
    public List<SysDiary> queryDiary() {
        LoginUser user = LoginInterceptor.getUser();
        List<Long> diaryIdList = userDiaryRelationService.queryByUserId(user.getId());
        ArrayList<SysDiary> diaryList = new ArrayList<>();
        for (Long id : diaryIdList) {
            diaryList.add(sysDiaryDao.selectByPrimaryKey(id));
        }
        return diaryList;
    }
}