package com.jd.m.cms.bjshare.domain.vo;

/**
 * @author huanglong
 * @Description: 查询商品对象
 * @date 2018/6/2010:21
 */
public class QuerySelfProduceVo {

    //一级分类id
    private String cid1;
    //二级分类id
    private String cid2;
    //三级分类id
    private String cid3;
    //商品名称
    private String searchKey;
    //采销erp
    private String saler;
    //页码
    private Integer pageNo = 1;
    //页大小
    private Integer pageSize = 8;

    public String getCid1() {
        return cid1;
    }

    public void setCid1(String cid1) {
        this.cid1 = cid1;
    }

    public String getCid2() {
        return cid2;
    }

    public void setCid2(String cid2) {
        this.cid2 = cid2;
    }

    public String getCid3() {
        return cid3;
    }

    public void setCid3(String cid3) {
        this.cid3 = cid3;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public String getSaler() {
        return saler;
    }

    public void setSaler(String saler) {
        this.saler = saler;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
