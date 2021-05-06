package com.qingyuan.redtour.pojo.BO;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: qyl
 * @Date: 2021/4/30 10:30
 */
@Data
@AllArgsConstructor
public class TokenBO<T> {
    /**
     * Token封装的对象
     */
    private T obj;

    /**
     * Token
     */
    private String token;
}
