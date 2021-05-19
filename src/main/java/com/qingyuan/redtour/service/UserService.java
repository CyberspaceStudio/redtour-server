package com.qingyuan.redtour.service;

import com.qingyuan.redtour.pojo.BO.TokenBO;
import com.qingyuan.redtour.pojo.Route;
import com.qingyuan.redtour.pojo.User;
import com.qingyuan.redtour.utils.ResponseEnum;
import com.qingyuan.redtour.utils.ResponseResult;

import java.util.List;

/**
 * @Author: qyl
 * @Date: 2021/4/29 22:03
 */
public interface UserService {

    /**
     * 微信小程序登录
     * @param code
     * @return
     */
    ResponseResult<TokenBO<User>> userWxLogin(String code);

    /**
     * 获取用户所有计划
     * @param userId
     * @return
     */
    ResponseResult<List<Route>> getUserPlan(Integer userId);

    /**
     * 获取用户所有收藏
     * @param userId
     * @return
     */
    ResponseResult<List<Route>> getUserStar(Integer userId);
}
