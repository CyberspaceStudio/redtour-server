package com.qingyuan.redtour.mapper;

import com.qingyuan.redtour.pojo.User;
import com.qingyuan.redtour.pojo.UserPlan;

/**
 * @Author: qyl
 * @Date: 2021/4/29 22:03
 */
public interface UserMapper {
    /**
     * 插入用户
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 根据 openid 查询用户
     * @param openid
     * @return
     */
    User getUserByOpenid(String openid);

    /**
     * 获取用户计划列表
     * @param userId
     * @param routeId
     * @return
     */
    UserPlan getUserPlanList(Integer userId);
}
