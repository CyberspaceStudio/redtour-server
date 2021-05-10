package com.qingyuan.redtour.controller;

import com.qingyuan.redtour.annotation.PassToken;
import com.qingyuan.redtour.pojo.BO.TokenBO;
import com.qingyuan.redtour.pojo.User;
import com.qingyuan.redtour.service.UserService;
import com.qingyuan.redtour.utils.ResponseResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户相关接口
 * @Author: qyl
 * @Date: 2021/4/29 22:04
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    /**
     * 微信验证登录小程序
     * 跳过token验证
     * @param code
     * @return
     */
    @PassToken
    @PostMapping("/login/wx")
    public ResponseResult<TokenBO<User>> userWxLogin(String code){return userService.userWxLogin(code);}
}
