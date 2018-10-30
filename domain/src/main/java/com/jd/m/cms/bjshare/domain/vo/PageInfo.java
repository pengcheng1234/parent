package com.jd.m.cms.bjshare.domain.vo;

import org.apache.poi.ss.formula.functions.T;

import java.io.Serializable;
import java.util.List;

/**
 * Created by LPC on 2018/9/25
 */
public class PageInfo<T> implements Serializable {

    private static final long serialVersionUID = 1L;
    private List<T> list;
    private int pageNum;
    private int pageSize;
    private long total;

    public  PageInfo(List<T> list,int pageNum,int pageSize,long total){
        this.list=list;
        this.pageNum=pageNum;
        this.pageSize=pageSize;
        this.total=total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
