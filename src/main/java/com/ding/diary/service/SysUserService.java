package com.ding.diary.service;

import com.ding.diary.entity.SysUser;

/**
 * @description: SysUserService
 * @author: ding
 * @date: 2019/10/15 21:05
 * @version: 1.0
 */
public interface SysUserService extends BaseService<SysUser> {

    String login(String username, String password);
}
