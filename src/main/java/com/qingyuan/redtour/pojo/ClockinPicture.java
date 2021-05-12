package com.qingyuan.redtour.pojo;

import lombok.Data;

/**
 * 每日打卡图片实体类
 * @Author: qyl
 * @Date: 2021/5/12 19:38
 */
@Data
public class ClockinPicture {
    /**
     * 每日打卡 ID
     */
    private Integer clockinId;

    /**
     * 图片地址
     */
    private String pictureUrl;
}
