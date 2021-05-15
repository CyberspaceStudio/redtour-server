package com.qingyuan.redtour.pojo;

import lombok.Data;

/**
 * @Author: qyl
 * @Date: 2021/4/29 22:03
 */
@Data
public class User {
    /**
     * 用户 ID
     */
    private Integer userId;

    /**
     * 微信小程序用户 ID
     */
    private String openid;

    /**
     * 用户名
     */
    private String username;

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

    public User(String openid) {
        this.openid = openid;
    }
}
