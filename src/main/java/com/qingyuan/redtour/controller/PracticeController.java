package com.qingyuan.redtour.controller;

import com.qingyuan.redtour.mapper.PracticeMapper;
import com.qingyuan.redtour.pojo.Practice;
import com.qingyuan.redtour.service.PracticeService;
import com.qingyuan.redtour.utils.ResponseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 实践相关接口
 * @Author: qyl
 * @Date: 2021/5/11 15:04
 */
@RestController
@RequestMapping("/practice")
public class PracticeController {
    @Resource
    private PracticeService practiceService;

    /**
     * 添加用户实践信息
     * @param practice
     * @return
     */
    @PostMapping("/add")
    public ResponseResult<Void> addUserPractice(@RequestBody Practice practice) {
        return practiceService.addUserPractice(practice);
    }
}
