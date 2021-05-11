package com.qingyuan.redtour.pojo;

import lombok.Data;

/**
 * 用户计划实体类
 * @Author: qyl
 * @Date: 2021/5/11 15:22
 */
@Data
public class UserPlan {
    /**
     * 用户 ID
     */
    private Integer userId;

    /**
     * 路线 ID
     */
    private Integer routeId;
}
