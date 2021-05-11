package com.qingyuan.redtour.controller;

import com.qingyuan.redtour.pojo.DailyClockin;
import com.qingyuan.redtour.utils.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: qyl
 * @Date: 2021/5/11 20:21
 */
@RestController
@RequestMapping("/clockin")
public class DailyClockinController {

    /**
     * 根据实践 ID 获取每日打卡列表
     * @param practiceId
     * @return
     */
    @GetMapping("/list")
    public ResponseResult<List<DailyClockin>> getDailyClockinList(Integer practiceId) {
        return null;
    }

    /**
     * 添加新的一天打卡
     * @param practiceId
     * @param clockin
     * @return
     */
    @PostMapping("/add")
    public ResponseResult<Void> addClockin(Integer practiceId, DailyClockin clockin) {
        return null;
    }
}
