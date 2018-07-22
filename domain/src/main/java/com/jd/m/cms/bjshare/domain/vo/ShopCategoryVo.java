package com.jd.m.cms.bjshare.domain.vo;

import java.io.Serializable;

/**
 * @author zhangxiangwei6
 * @create 2018-04-20 18:02
 **/
public class ShopCategoryVo implements Serializable {

	private static final long serialVersionUID = -6209901538390218634L;

	private long id;
	private long shopId;
	private long parentId;
	private String title;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getShopId() {
		return shopId;
	}

	public void setShopId(long shopId) {
		this.shopId = shopId;
	}

	public long getParentId() {
		return parentId;
	}

	public void setParentId(long parentId) {
		this.parentId = parentId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
