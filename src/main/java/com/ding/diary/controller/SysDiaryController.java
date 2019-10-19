package com.ding.diary.controller;


import com.ding.diary.entity.SysDiary;
import com.ding.diary.exception.CustomException;
import com.ding.diary.service.SysDiaryService;
import com.ding.diary.util.MyStringUtil;
import com.ding.diary.util.ResponseUtils;
import com.ding.diary.vo.ResponseVO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SysDiary)表控制层
 *
 * @author makejava
 * @since 2019-10-15 20:52:41
 */
@RestController
@RequestMapping("diary")
public class SysDiaryController {
    /**
     * 服务对象
     */
    @Resource
    private SysDiaryService sysDiaryService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public ResponseVO selectOne(Integer id) {
        return ResponseUtils.success(this.sysDiaryService.queryById(id));
    }


    @PostMapping("save")
    public ResponseVO save(@RequestParam("content") String content, @RequestParam("place") String place) {
        if (MyStringUtil.isEmpty(content))
            throw new CustomException("缺少参数");
        Boolean result = this.sysDiaryService.insert(content, place);
        if (!result) throw new CustomException("保存失败,请稍后重试");
        return ResponseUtils.success();
    }

    @PostMapping("getDiary")
    public ResponseVO getDiary() {
        List<SysDiary> diaryList = this.sysDiaryService.queryDiary();
        return ResponseUtils.success(diaryList);
    }
}