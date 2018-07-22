package com.jd.m.cms.bjshare.common.spring;

/**
 * jsf provider接口服务
 * 
 * @author njzhufeifei
 */
public class JsfException extends Exception {

    private static final long serialVersionUID = 1L;

    /**
     * 异常码
     */
    private String code;

    public JsfException(Throwable t, String code, String message) {
        super(message, t);
        this.code = code;
    }
    
    public JsfException(Throwable t, String code) {
        super(t);
        this.code = code;
    }
    
    public JsfException(String code, String message) {
        super(message);
        this.code = code;
    }

    public JsfException(String code) {
        super();
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
