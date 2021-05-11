package com.qingyuan.redtour.pojo;

import lombok.Data;

/**
 * 用户收藏实体类
 * @Author: qyl
 * @Date: 2021/5/11 19:26
 */
@Data
public class UserStar {
    /**
     * 用户 ID
     */
    private Integer userId;

    /**
     * 路线 ID
     */
    private Integer routeId;
}
