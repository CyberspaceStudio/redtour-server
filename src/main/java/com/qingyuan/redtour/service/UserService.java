package com.qingyuan.redtour.service;

import com.qingyuan.redtour.pojo.BO.TokenBO;
import com.qingyuan.redtour.pojo.User;
import com.qingyuan.redtour.utils.ResponseEnum;
import com.qingyuan.redtour.utils.ResponseResult;

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
}
