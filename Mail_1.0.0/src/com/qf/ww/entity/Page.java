package com.qf.ww.entity;

import java.util.List;

public class Page {
    //当前页   --  前端获取
    private int currentPage;

    //总条数   --  数据库获取
    private int totalCount;

    //总页数   --  实体类中定义公式
    private int pageCount;

    //每页展示的数据量  --  后台设置
    private int pageSize;

    //每页展示的数据集合 --  数据库获取
    public List<?> list;


    public Page() {
    }

    public Page(int currentPage, int totalCount, int pageSize, List<?> list) {
        this.currentPage = currentPage;
        this.totalCount = totalCount;
        this.pageSize = pageSize;
        this.list = list;
        this.pageCount = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    //给数据总条数赋值
    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        //判断每页展示的数据量是否已赋值
        if (this.pageSize != 0) {
            this.pageCount = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        }
    }

    public int getPageCount() {
        return pageCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    //给每页展示的数据量赋值
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        //数据总条数如果不为0
        if (this.totalCount != 0) {
            this.pageCount = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1;
        }
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Page{" +
                "currentPage=" + currentPage +
                ", totalCount=" + totalCount +
                ", pageCount=" + pageCount +
                ", pageSize=" + pageSize +
                ", list=" + list +
                '}';
    }
}
