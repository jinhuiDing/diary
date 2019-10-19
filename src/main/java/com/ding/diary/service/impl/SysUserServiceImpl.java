package com.ding.diary.service.impl;

import com.ding.diary.dao.SysUserDao;
import com.ding.diary.entity.SysUser;
import com.ding.diary.exception.CustomException;
import com.ding.diary.service.SysUserService;
import com.ding.diary.util.JwtTokenUtils;
import com.ding.diary.util.Md5Util;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import javax.annotation.Resource;
import java.util.HashMap;

/**
 * @description: SysUserServiceImpl
 * @author: ding
 * @date: 2019/10/15 21:06
 * @version: 1.0
 */

@Service
public class SysUserServiceImpl extends BaseServiceImpl<SysUser> implements SysUserService {
    @Resource
    SysUserDao sysUserDao;

    @Override
    public Mapper<SysUser> getMapper() {
        return sysUserDao;
    }

    @Override
    public String login(String username, String password) {
        String token = null;
        SysUser user = new SysUser();
        user.setName(username);
        SysUser sysUser = sysUserDao.selectOne(user);
        if (sysUser == null) throw new CustomException("用户不存在");
        password += sysUser.getSalt();
        if (Md5Util.encodeByMd5(password).equals(sysUser.getPassword())) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("username", username);
            map.put("id", sysUser.getId());
            token = JwtTokenUtils.generatorToken(map);

        }
        return token;
    }
}
