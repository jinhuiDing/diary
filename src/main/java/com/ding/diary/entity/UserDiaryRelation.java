package com.ding.diary.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (UserDiaryRelation)实体类
 *
 * @author makejava
 * @since 2019-10-18 21:40:12
 */
@Data
public class UserDiaryRelation implements Serializable {
    private static final long serialVersionUID = -43039548915933204L;
    
    private Long id;
    
    private Long diaryId;
    
    private Long userId;


    public UserDiaryRelation(Long userId, Long diaryId) {
        this.userId=userId;
        this.diaryId=diaryId;
    }
}