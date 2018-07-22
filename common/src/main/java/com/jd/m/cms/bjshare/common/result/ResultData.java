package com.jd.m.cms.bjshare.common.result;

import java.io.Serializable;


/**
 * 请求响应数据
 * 
 * @author njzhufeifei
 */
public class ResultData implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String CODE_KEY = "code";

	public static final String MESSAGE_KEY = "message";

	private String code;

	private String message;

	private Object result;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

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

	public ResultData(String code, String message,Object result) {
		this.code = code;
		this.message = message;
		this.result=result;
	}

	public ResultData(String code, String message) {
		this.code = code;
		this.message = message;
	}
	public ResultData(){};

}
