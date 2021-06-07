package com.qf.ww.entity;

import java.util.Date;

public class Product {
    private int id;
    private String name; //产品名称
    private String subTitle; //产品描述（小标题）
    private float price; //产品价格
    private int stock; //产品库存
    private int cid; //分类id
    private Date createDate; //创建日期
    private String imgUrl;  //产品图片存储路径

    public Product() {
    }

    public Product(String name, String subTitle, float price, int stock, int cid, Date createDate, String imgUrl) {
        this.name = name;
        this.subTitle = subTitle;
        this.price = price;
        this.stock = stock;
        this.cid = cid;
        this.createDate = createDate;
        this.imgUrl = imgUrl;
    }

    public Product(int id, String name, String subTitle, float price, int stock, int cid, Date createDate, String imgUrl) {
        this.id = id;
        this.name = name;
        this.subTitle = subTitle;
        this.price = price;
        this.stock = stock;
        this.cid = cid;
        this.createDate = createDate;
        this.imgUrl = imgUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                ", cid=" + cid +
                ", createDate=" + createDate +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }
}
