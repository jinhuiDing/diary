package com.ding.diary.controller;

import com.ding.diary.anno.Anonymous;
import com.ding.diary.entity.SysUser;
import com.ding.diary.exception.CustomException;
import com.ding.diary.service.SysDiaryService;
import com.ding.diary.service.SysUserService;
import com.ding.diary.util.Md5Util;
import com.ding.diary.util.ResponseUtils;
import com.ding.diary.vo.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    @Autowired
    private SysDiaryService sysDiaryService;

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
    public String loginHtml(HttpServletRequest request) {
        String contextPath = request.getContextPath();
        System.out.println("contextPath = " + contextPath);
        return "login";
    }

    @Anonymous
    @GetMapping("register")
    public String registerHtml() {
        return "register";
    }



    @GetMapping("diary")
    @Anonymous
    public String diaryHtml(Model model,HttpServletRequest request){
        return "diary";
    }
    @GetMapping("editDiary")
    @Anonymous
    public String editDiary(){
        return "editDiary";
    }








    @Anonymous
    @PostMapping("loginUser")
    @ResponseBody
    public ResponseVO login(HttpServletResponse response, @RequestParam("username") String username, @RequestParam("password") String password) {
        String token = this.sysUserService.login(username, password);
        if (token == null || "".equals(token)) {
            throw new CustomException("登录失败");
        }
        return ResponseUtils.success(token);

    }

    @Anonymous
    @PostMapping("registerUser")
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
        if (insert == 0) {
            throw new CustomException("注册失败");
        }
        return ResponseEntity.ok(null);
    }
}