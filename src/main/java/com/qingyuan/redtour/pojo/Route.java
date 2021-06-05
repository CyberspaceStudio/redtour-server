package com.qingyuan.redtour.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 旅游路线实体类
 * @Author: qyl
 * @Date: 2021/5/11 9:04
 */
@Data
public class Route implements Serializable {
    private static final long serialVersionUID = 2296912434107264400L;
    /**
     * 路线 ID
     */
    private Integer routeId;

    /**
     * 路线分类
     * @apiNote 1 代表红色中国；2 代表小康中国；3 代表复兴中国；4 代表游览本地
     */
    private Integer category;

    /**
     * 风景图 URL
     */
    private String scenicPictureUrl;

    /**
     * 路线名称
     */
    private String routeName;

    /**
     * 地点
     */
    private String location;

    /**
     * 建议旅行天数
     */
    private String suggestedDay;

    /**
     * 出行方式（自驾游、租赁大巴...）
     */
    private String travelMode;

    /**
     * 路线简介
     */
    private String intro;
}
