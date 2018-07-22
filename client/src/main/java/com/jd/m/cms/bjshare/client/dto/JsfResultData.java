package com.jd.m.cms.bjshare.client.dto;

import java.io.Serializable;

/**
 * Created by lipengcheng on 2018/7/5.
 */
public class JsfResultData implements Serializable {
    private static final long serialVersionUID = -3453104950865321231L;

    private Object result;
    private boolean success;
    private String code;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public JsfResultData(Object result, boolean success, String code, String message) {
        this.result = result;
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public JsfResultData() {
    }
}
