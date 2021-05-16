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
    USER_NO_EXIST(2002,"用户不存在"),

    // 路线错误 3001-3999
    CATEGORY_NO_EXIST(3001,"分类不存在"),
    ROUTE_NO_EXIST(3002,"路线不存在"),

    // 计划错误 4001-4999
    PLAN_HAS_EXIT(4001,"路线已在计划中"),
    STAR_HAS_EXIT(4001,"路线已在收藏中"),
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
