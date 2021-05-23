package com.qingyuan.redtour.mapper;

import com.qingyuan.redtour.pojo.Practice;

/**
 * @Author lmx
 * @Date 2021/5/23 15:16
 * @Version 1.0
 */
public interface PracticeMapper {
    /**
     * 增加用户实践
     * @param practice
     * @return
     */
    int addUserPractice(Practice practice);
}
