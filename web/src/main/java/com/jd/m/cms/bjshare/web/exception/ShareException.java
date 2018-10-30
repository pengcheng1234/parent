package com.jd.m.cms.bjshare.web.exception;

/**
 * @author huanglong
 * @Description: 自定义异常
 * @date 2018/6/1317:19
 */
public class ShareException extends Exception{

    private static final long serialVersionUID = 1L;

    /**
     * 异常码
     */
    private String code;

    public ShareException(Throwable t, String code, String message) {
        super(message, t);
        this.code = code;
    }

    public ShareException(Throwable t, String code) {
        super(t);
        this.code = code;
    }

    public ShareException(String code, String message) {
        super(message);
        this.code = code;
    }

    public ShareException(String code) {
        super();
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
