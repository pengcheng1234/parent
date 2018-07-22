package com.jd.m.cms.bjshare.domain.enums;

/**
 * @author huanglong
 * @Description: 自定义的异常
 * @date 2018/6/1317:27
 */
public enum ShareExceptionEnum {

    JSF_ERROR("100","网络异常，稍后重试"); //依赖的jsf接口问题，统一提示网络异常
    private String code;
    private String msg;

    ShareExceptionEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
