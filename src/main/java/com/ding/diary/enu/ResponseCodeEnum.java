package com.ding.diary.enu;

/**
 * @description: ResponseCodeEnum
 * @author: ding
 * @date: 2019/10/18 15:38
 * @version: 1.0
 */
public enum ResponseCodeEnum {

    /**
     * 响应状态码
     */
    SUCCESS(1000, "成功"),
    FORBIDDEN(1001, "无权访问"),

    UN_LOGIN(1002, "您没有登录"),
    ERROR(1002,"失败") ;
    Integer code;
    String msg;

    ResponseCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getMsg(){
        return msg;
    }
    public Integer getCode(){
        return code;
    }
}
