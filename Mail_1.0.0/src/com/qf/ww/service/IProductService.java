package com.qf.ww.service;

import com.qf.ww.entity.Message;
import com.qf.ww.entity.Page;
import org.apache.commons.fileupload.FileItem;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface IProductService {
    /**
     * 获取分类产品数据业务（分页）
     * @param currentPage 当前页
     * @param cid 类目id
     * @return
     */
    Page getPageByCid(int currentPage,int cid);

    /**
     *  获取分类产品数据业务
     * @param cid
     * @return
     */
    Message getProductByCid(int cid);

    /**
     *  添加产品
     * @param list
     * @param path
     * @return
     */
    Message addProduct(List<FileItem> list, String path) throws IOException, InvocationTargetException, IllegalAccessException;

    /**
     *  删除产品
     * @param id
     * @return
     */
    Message deleteProduct(int id);

    /**
     *  获取所有产品
     * @return
     */
    Message getProductList();
}
