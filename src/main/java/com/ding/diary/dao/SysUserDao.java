package com.ding.diary.dao;

import com.ding.diary.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description: SysUserDao
 * @author: ding
 * @date: 2019/10/15 21:07
 * @version: 1.0
 */

@Mapper
public interface SysUserDao extends tk.mybatis.mapper.common.Mapper<SysUser> {

}
