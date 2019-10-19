package com.ding.diary.entity;

import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * (SysDiary)实体类
 *
 * @author makejava
 * @since 2019-10-15 20:52:38
 */
@Data
public class SysDiary implements Serializable {
    private static final long serialVersionUID = -28734161278203104L;

    @Id
    @GeneratedValue(generator = "JDBC")
    private Long id;


    private Date createTime;
    //具体内容
    private String content;
    //地点
    private String place;




}