package com.qingyuan.redtour.mapper;

import com.qingyuan.redtour.pojo.User;

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
     * 根据openid查询用户
     * @param openid
     * @return
     */
    User getUserByOpenid(String openid);
}
