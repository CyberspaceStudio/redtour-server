package com.qingyuan.redtour.service;

import com.qingyuan.redtour.pojo.Practice;
import com.qingyuan.redtour.utils.ResponseResult;

/**
 * @Author lmx
 * @Date 2021/5/23 15:17
 * @Version 1.0
 */
public interface PracticeService {
    ResponseResult<Void> addUserPractice(Practice practice);
}
