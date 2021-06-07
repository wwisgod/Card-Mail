package com.qf.ww.dao;

import com.qf.ww.entity.Product;

import java.util.List;

public interface IProductDao {
    /**
     *  根据分类id获取所属产品集合
     * @param cid
     * @return
     */
    List<Product> getProductByCid(int cid);

    /**
     *  根据分类 获取的每页展示的数据量
     * @param cid
     * @param offset
     * @param pageSize
     * @return
     */
    List<Product> getPageByCid(int cid,int offset,int pageSize);

    /**
     *  根据分类id获取共有多少条数据
     * @param cid
     * @return
     */
    int getTotalCountByCid(int cid);

    /**
     *  获取所有产品集合
     * @return
     */
    List<Product> getProductList();

    /**
     *  获取分每页展示的数据量
     * @param offset
     * @param pageSize
     * @return
     */
    List<Product> getPage(int offset,int pageSize);
    /**
     * 获取共有多少条产品数据
     * @return
     */
    int getTotalCount();

    /**
     *  添加产品
     * @param product
     * @return
     */
    int addProduct(Product product);

    /**
     *  删除产品
     * @param id
     * @return
     */
    int deleteProduct(int id);
}
