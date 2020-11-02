package com.zlsoft.framework.model.response;

import lombok.ToString;

/**
 *
 */

@ToString
public enum CommonCode implements ResultCode{
    INVALID_PARAM(false,400,"非法参数！"),
    SUCCESS(true,200,"操作成功！"),
    FAIL(false,403,"操作失败！"),
    SERVER_ERROR(false,500,"抱歉，系统繁忙，请稍后重试！"),

    INSET_ERROR(false,4001,"添加失败！");


    //操作是否成功
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;
    private CommonCode(boolean success,int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }

    @Override
    public boolean success() {
        return success;
    }
    @Override
    public int code() {
        return code;
    }

    @Override
    public String message() {
        return message;
    }


}
