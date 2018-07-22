package com.jd.m.cms.bjshare.domain.vo;

/**
 * @author huanglong
 * @Description: 查询自营商品返回的对象
 * @date 2018/6/2016:41
 */
public class QuerySelfProduceResponseVo {

    //商品名称
    private String title;
    //商品主图
    private String  img;
    //京东价格
    private Double price;
    //类目
    private String sku;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
}
