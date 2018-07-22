package com.jd.m.cms.bjshare.domain.po;

import java.io.Serializable;

public class ShareContent implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     * 主键
     */
    private long id;

	/**
     * 创建者
     */
    private String creator;

    private java.util.Date createTime;

    private long createDate;

	/**
     * 修改者
     */
    private String modifier;

    private java.util.Date modifyTime;

    private long modifyDate;

    private boolean isDelete;

	/**
     * 匹配类型：0:商品，1:店铺
     */
    private int type;

	/**
     * 店铺ID或者skuID
     */
    private String bizIds;

	/**
     * 多个分享标题
     */
    private String titles;

	/**
     * 过个分享描述语
     */
    private String contents;

	public long getId() {
        return id;
    }
	
	public void setId(long id) {
        this.id = id;
    }
	public String getCreator() {
        return creator;
    }
	
	public void setCreator(String creator) {
        this.creator = creator;
    }
	public java.util.Date getCreateTime() {
        return createTime;
    }
	
	public void setCreateTime(java.util.Date createTime) {
        this.createTime = createTime;
    }
	public long getCreateDate() {
        return createDate;
    }
	
	public void setCreateDate(long createDate) {
        this.createDate = createDate;
    }
	public String getModifier() {
        return modifier;
    }
	
	public void setModifier(String modifier) {
        this.modifier = modifier;
    }
	public java.util.Date getModifyTime() {
        return modifyTime;
    }
	
	public void setModifyTime(java.util.Date modifyTime) {
        this.modifyTime = modifyTime;
    }
	public long getModifyDate() {
        return modifyDate;
    }
	
	public void setModifyDate(long modifyDate) {
        this.modifyDate = modifyDate;
    }
	public boolean getIsDelete() {
        return isDelete;
    }
	
	public void setIsDelete(boolean isDelete) {
        this.isDelete = isDelete;
    }
	public int getType() {
        return type;
    }
	
	public void setType(int type) {
        this.type = type;
    }
	public String getBizIds() {
        return bizIds;
    }
	
	public void setBizIds(String bizIds) {
        this.bizIds = bizIds;
    }
	public String getTitles() {
        return titles;
    }
	
	public void setTitles(String titles) {
        this.titles = titles;
    }
	public String getContents() {
        return contents;
    }
	
	public void setContents(String contents) {
        this.contents = contents;
    }

}
