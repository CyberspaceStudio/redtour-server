package com.qingyuan.redtour.pojo.BO;

import lombok.Data;

/**
 * 微信返回数据对象
 * @Author: qyl
 * @Date: 2021/4/30 10:33
 */
@Data
public class WxResponseInfo {
    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 用户唯一标识
     */
    private String openid;

    /**
     * 会话密钥
     */
    private String session_key;

    /**
     * 微信返回错误代码
     */
    private String errcode;

    /**
     * 微信返回错误信息
     */
    private String errmsg;
}
