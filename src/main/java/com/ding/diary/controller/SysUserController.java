package com.ding.diary.controller;

import com.ding.diary.anno.Anonymous;
import com.ding.diary.entity.SysUser;
import com.ding.diary.exception.CustomException;
import com.ding.diary.service.SysUserService;
import com.ding.diary.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * (SysUser)表控制层
 *
 * @author makejava
 * @since 2019-10-15 21:05:17
 */
@Controller
@RequestMapping("sysUser")
public class SysUserController {
    /**
     * 服务对象
     */
    @Autowired
    private SysUserService sysUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    @ResponseBody
    public ResponseEntity<SysUser> selectOne(@RequestParam Long id) {
        return ResponseEntity.ok((SysUser) this.sysUserService.queryById(id));
    }


    @Anonymous
    @GetMapping("login")
    public String loginHtml() {
        return "login";
    }

    @Anonymous
    @PostMapping("loginUser")
    public ResponseEntity login(@RequestParam("username") String username, @RequestParam("password") String password) {
        String token = this.sysUserService.login(username, password);
        if (token == null || token.equals("")) {
            throw new CustomException("登录失败");
        }
        return ResponseEntity.ok(token);

    }

    @Anonymous
    @PostMapping("register")
    public ResponseEntity register(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("phone") String phone) {
        SysUser sysUser = new SysUser();
        sysUser.setPhone(phone);
        sysUser.setSalt(UUID.randomUUID().toString().replace("-", ""));
        password += sysUser.getSalt();
        try {
            sysUser.setPassword(Md5Util.encodeByMd5(password));
        } catch (Exception e) {
            e.printStackTrace();
        }

        sysUser.setName(username);
        int insert = this.sysUserService.insert(sysUser);
        if (insert==0) throw new CustomException("注册失败");
        return ResponseEntity.ok(null);
    }
}