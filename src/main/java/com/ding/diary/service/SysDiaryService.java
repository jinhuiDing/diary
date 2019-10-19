package com.ding.diary.service;

import com.ding.diary.entity.SysDiary;

import java.util.List;

/**
 * (SysDiary)表服务接口
 *
 * @author makejava
 * @since 2019-10-15 20:52:40
 */
public interface SysDiaryService extends BaseService<SysDiary> {


    Boolean insert(String content, String place);

    List<SysDiary> queryDiary();
}