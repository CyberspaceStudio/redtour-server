package com.qingyuan.redtour.controller;

import com.qingyuan.redtour.pojo.BO.TokenBO;
import com.qingyuan.redtour.pojo.Practice;
import com.qingyuan.redtour.pojo.Route;
import com.qingyuan.redtour.pojo.User;
import com.qingyuan.redtour.service.UserService;
import com.qingyuan.redtour.utils.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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
     * 微信小程序登录
     * @param code
     * @return
     */
    @PostMapping("/login/wx")
    public ResponseResult<TokenBO<User>> userWxLogin(String code) {
        return userService.userWxLogin(code);
    }

    /**
     * 获取用户所有计划
     * @param userId
     * @return
     */
    @GetMapping("/plan")
    public ResponseResult<List<Route>> getUserPlan(Integer userId) {
        return userService.getUserPlan(userId);
    }

    /**
     * 获取用户所有收藏路线
     * @param userId
     * @return
     */
    @GetMapping("/star")
    public ResponseResult<List<Route>> getUserStar(Integer userId) {
        return userService.getUserStar(userId);
    }

    /**
     * 获取用户实践记录
     * @param userId
     * @return
     */
    @GetMapping("/practice")
    public ResponseResult<Practice> getUserPractice(Integer userId) {
        return null;
    }

    /**
     * 该路线从用户收藏中移除
     * @param userId
     * @param routeId
     * @return
     */
    @PostMapping("/plan/remove")
    public ResponseResult<Void> removeFromUserPlan(Integer userId, Integer routeId) {
        return null;
    }

    /**
     * 取消收藏该路线
     * @param userId
     * @param routeId
     * @return
     */
    @PostMapping("/star/remove")
    public ResponseResult<Void> removeFromUserStar(Integer userId, Integer routeId) {
        return null;
    }
}
