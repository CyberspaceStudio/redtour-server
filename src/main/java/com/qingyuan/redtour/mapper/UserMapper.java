package com.qingyuan.redtour.mapper;

import com.qingyuan.redtour.pojo.Practice;
import com.qingyuan.redtour.pojo.Route;
import com.qingyuan.redtour.pojo.User;
import com.qingyuan.redtour.pojo.UserPlan;

import java.util.List;

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
     * @return
     */
    List<Route> getUserPlanList(Integer userId);

    /**
     * 获取用户收藏
     * @param userId
     * @return
     */
    List<Route> getUserStar(Integer userId);

    /**
     * 获取用户实践
     * @param userId
     * @return
     */
    Practice getUserPractice(Integer userId);
}
