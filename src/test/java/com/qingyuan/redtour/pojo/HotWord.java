package com.qingyuan.redtour.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author hly
 * @Description: 热词实体类
 * @create 2021-05-24 22:42
 */
@Data
@AllArgsConstructor
public class HotWord implements Serializable {
    /**
     * 热度
     */
    private double score;

    /**
     * value
     */
    private String value;
}
