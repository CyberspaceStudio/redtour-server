package com.qingyuan.redtour.pojo;

import lombok.Data;

/**
 * 路线景点实体类
 * @Author: qyl
 * @Date: 2021/5/12 20:17
 */
@Data
public class Attraction {
    /**
     * 景点 ID
     */
    private Integer attractionId;

    /**
     * 对应的路线 ID
     */
    private Integer routeId;

    /**
     * 景点名称
     */
    private String attractionName;

    /**
     * 景点介绍
     */
    private String intro;
}
