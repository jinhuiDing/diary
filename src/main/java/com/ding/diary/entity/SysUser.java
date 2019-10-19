package com.ding.diary.entity;

import lombok.Data;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * (SysUser)实体类
 *
 * @author makejava
 * @since 2019-10-15 21:05:17
 */
@Data
public class SysUser implements Serializable {
    private static final long serialVersionUID = -55560823219456319L;
    //主键
    @Id
    private Long id;
    //用户名
    private String name;
    //密码
    private String password;
    //注册时间
    private Date createTime;
    //手机号
    private String phone;
    private String salt;



}