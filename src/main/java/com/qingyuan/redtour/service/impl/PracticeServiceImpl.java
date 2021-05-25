package com.qingyuan.redtour.service.impl;

import com.qingyuan.redtour.mapper.PracticeMapper;
import com.qingyuan.redtour.pojo.Practice;
import com.qingyuan.redtour.service.PracticeService;
import com.qingyuan.redtour.utils.ResponseEnum;
import com.qingyuan.redtour.utils.ResponseResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author lmx
 * @Date 2021/5/23 15:17
 * @Version 1.0
 */
@Service
public class PracticeServiceImpl implements PracticeService {
    @Resource
    private PracticeMapper practiceMapper;

    @Override
    public ResponseResult<Void> addUserPractice(Practice practice) {
        int i = practiceMapper.addUserPractice(practice);
        if (i > 0) {
            return ResponseResult.ok();
        }
        return ResponseResult.fail(ResponseEnum.PRACTICE_ADD_ERROR.getCode(), ResponseEnum.PRACTICE_ADD_ERROR.getMsg());
    }
}
