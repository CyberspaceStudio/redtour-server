package com.qingyuan.redtour.pojo;

import lombok.Data;

/**
 * 高校实践实体类
 * @Author: qyl
 * @Date: 2021/5/11 9:17
 */
@Data
public class Practice {
    /**
     * 实践 ID
     */
    private Integer practiceId;

    /**
     * 用户 ID
     */
    private Integer userId;

    /**
     * 大学
     */
    private String university;

    /**
     * 学生姓名
     */
    private String studentName;

    /**
     * 学生学号
     */
    private String studentId;
}
