package com.jd.m.cms.bjshare.domain.enums;

import java.util.HashSet;

public enum ShareContentType{
	PRODUCT(0,"商品"),
	VENDER(1,"店铺");
	private Integer code;
	private String desc;

	private final static HashSet<Integer> values = new HashSet<Integer>();
	static{
		for (ShareContentType c : ShareContentType.values()) {
			values.add(c.getCode());
		}
	}

	private ShareContentType(Integer code, String desc) {
		this.code = code;
		this.desc = desc;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public static boolean contains(Integer code){
		return values.contains(code);
	}
}