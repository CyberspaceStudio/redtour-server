package com.qingyuan.redtour.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 每日打卡实体类
 * @Author: qyl
 * @Date: 2021/5/11 9:21
 */
@Data
public class DailyClockin {
    /**
     * 每日打卡 ID
     */
    private Integer clockinId;

    /**
     * 对应的实践 ID
     */
    private Integer practiceId;

    /**
     * 实践打卡日期
     * @apiNote 日期格式为 xxxx/xx/xx
     */
    @JsonFormat(pattern = "yyyy/MM/dd", timezone = "Asia/Shanghai")
    private Date date;

    /**
     * 实践名称
     */
    private String practiceName;

    /**
     * 实践地点
     */
    private String location;

    /**
     * 实践队员
     */
    private String teammate;

    /**
     * 实践介绍
     */
    private String practiceIntro;
}
