package com.qingyuan.redtour.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * 路线景点实体类
 * @Author: qyl
 * @Date: 2021/5/12 20:17
 */
@Data
public class Attraction implements Serializable {
    private static final long serialVersionUID = 3569812631401627197L;
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
