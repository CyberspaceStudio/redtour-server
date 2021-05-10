package com.qingyuan.redtour.pojo;

import lombok.Data;

/**
 * @Author: qyl
 * @Date: 2021/4/29 22:03
 */
@Data
public class User {
    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 微信小程序用户ID
     */
    private String openid;

    /**
     * 用户名
     */
    private String username;

    /**
     * 用户头像地址
     */
    private String avatarUrl;

    /**
     * 用户积分
     * @apiNote 暂未开通
     */
    private Integer credits;

    /**
     * 用户身份
     * @apiNote 暂未开通
     */
    private Integer identity;

    public User(Integer userId) {
        this.userId = userId;
    }

    public User(String openid) {
        this.openid = openid;
    }

    public User() {
    }
}
