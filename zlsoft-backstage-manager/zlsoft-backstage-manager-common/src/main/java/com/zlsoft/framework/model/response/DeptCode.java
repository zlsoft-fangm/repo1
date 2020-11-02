package com.zlsoft.framework.model.response;

import lombok.ToString;

@ToString
public enum  DeptCode  implements ResultCode{

    DEPT_ADDPAGE_EXISTSNAME(false,24001,"添加信息已存在！"),
    DEPT_GENERATEHTML_DATAURLISNULL(false,24002,"从页面信息中找不到获取数据的url！"),
    DEPT_GENERATEHTML_DATAISNULL(false,24003,"根据页面的数据url获取不到数据！"),
    DEPT_GENERATEHTML_TEMPLATEISNULL(false,24004,"页面模板为空！"),
    DEPT_GENERATEHTML_HTMLISNULL(false,24005,"生成的静态html为空！"),
    DEPT_GENERATEHTML_SAVEHTMLERROR(false,24005,"保存静态html出错！"),
    DEPT_PAGE_NOTEXISTS(false,24006,"页面不存在"),
    DEPT_COURSE_PERVIEWISNULL(false,24007,"预览页面为空！");
    //操作代码
    boolean success;
    //操作代码
    int code;
    //提示信息
    String message;

    private DeptCode(boolean success, int code, String message){
        this.success = success;
        this.code = code;
        this.message = message;
    }


    @Override
    public boolean success() {
        return false;
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