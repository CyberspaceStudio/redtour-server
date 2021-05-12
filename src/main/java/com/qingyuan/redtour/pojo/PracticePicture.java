package com.qingyuan.redtour.pojo;

import lombok.Data;

/**
 * @Author: qyl
 * @Date: 2021/5/11 9:35
 */
@Data
public class PracticePicture {
    /**
     * 对应的每日打卡 ID
     */
    private Integer clockinId;

    /**
     * 实践图片 URL
     */
    private String pictureUrl;
}
