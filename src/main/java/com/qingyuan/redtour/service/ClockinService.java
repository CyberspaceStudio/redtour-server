package com.qingyuan.redtour.service;

import com.qingyuan.redtour.pojo.BO.ClockinBO;
import com.qingyuan.redtour.pojo.Clockin;
import com.qingyuan.redtour.utils.ResponseResult;

import java.util.List;

/**
 * @Author lmx
 * @Date 2021/5/17 23:56
 * @Version 1.0
 */
public interface ClockinService {

    /**
     * 根据 practiceID 获取每日打卡列表
     * @param practiceId
     * @return
     */
    ResponseResult<List<Clockin>> getDailyClockinList(Integer practiceId);

    /**
     * 获取具体某一天的打卡记录
     * @param clockinId
     * @return
     */
    ResponseResult<ClockinBO> getClockinById(Integer clockinId);
}
