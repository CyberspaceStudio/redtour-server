package com.qingyuan.redtour.controller;

import com.qingyuan.redtour.pojo.Practice;
import com.qingyuan.redtour.utils.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 实践相关接口
 * @Author: qyl
 * @Date: 2021/5/11 15:04
 */
@RestController
@RequestMapping("/practice")
public class PracticeController {

    /**
     * 添加用户实践信息
     * @param practice
     * @return
     */
    @PostMapping("/add")
    public ResponseResult<Void> addUserPractice(Practice practice) {
        return null;
    }
}
