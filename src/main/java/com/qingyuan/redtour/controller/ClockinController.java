package com.qingyuan.redtour.controller;

import com.qingyuan.redtour.pojo.BO.ClockinBO;
import com.qingyuan.redtour.pojo.Clockin;
import com.qingyuan.redtour.service.ClockinService;
import com.qingyuan.redtour.utils.ResponseResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 每日打卡相关接口
 * @Author: qyl
 * @Date: 2021/5/11 20:21
 */
@RestController
@RequestMapping("/clockin")
public class ClockinController {

    @Resource
    private ClockinService clockinService;

    /**
     * 根据实践 ID 获取每日打卡列表
     * @param practiceId
     * @return
     */
    @GetMapping("/list")
    public ResponseResult<List<Clockin>> getDailyClockinList(Integer practiceId) {
        return clockinService.getDailyClockinList(practiceId);
    }

    /**
     * 获取具体某一天的打卡记录
     * @param clockinId
     * @return
     */
    @GetMapping("/id")
    public ResponseResult<ClockinBO> getClockinById(Integer clockinId) {
        return clockinService.getClockinById(clockinId);
    }

    /**
     * 添加新的一天打卡
     * @param clockinBO
     * @return
     */
    @PostMapping("/add")
    public ResponseResult<Void> addClockin(@RequestBody ClockinBO clockinBO) {
        return clockinService.addClockin(clockinBO);
    }
}
