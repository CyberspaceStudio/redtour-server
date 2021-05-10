package com.qingyuan.redtour.utils;

/**
 * @Author: qyl
 * @Date: 2020/12/7 9:54
 */
public enum ResponseEnum {
    SUCCESS(1, "成功"),
    FAIL(0, "失败"),

    // 参数错误 1001-1999
    CODE_IS_INVALID(1001, "code无效"),

    // 用户错误 2001-2999
    USER_HAVE_EXIST(2001, "用户已存在"),
    ;
    /**
     * 状态码
     */
    private int code;

    /**
     * 状态信息
     */
    private String msg;

    ResponseEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
