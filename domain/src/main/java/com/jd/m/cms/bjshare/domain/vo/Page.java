package com.jd.m.cms.bjshare.domain.vo;

import java.util.List;

/**
 * @author huanglong
 * @Description: 分页对象
 * @date 2018/6/2016:57
 */
public class Page<T> {
    private long totalItem;
    private List<T> data;
    private int pageNo;
    private int pageSize;

    public Page() {
    }

    public long getTotalItem() {
        return this.totalItem;
    }

    public void setTotalItem(long totalItem) {
        this.totalItem = totalItem;
    }

    public List<T> getData() {
        return this.data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getPageNo() {
        return this.pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}


