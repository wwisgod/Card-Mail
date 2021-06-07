package com.qf.ww.dao;

import com.qf.ww.entity.Category;

import java.util.List;

public interface ICategoryDao {
    /**
     *  查询所有类目信息
     * @return list 类目信息集合
     */
    List<Category> getCategoryList();

    /**
     *  删除所选类目
     * @param id 类目id
     * @return 1 操作成功 0 操作失败
     */
    int deleteCategory(int id);

    /**
     *  获取指定的类目信息
     * @param id 类目id
     * @return  含有单个类目数据的list集合
     */
    List<Category> getCategoryInfo(int id);

    /**
     * 修改指定的类目信息
     * @param id 类目id
     * @param name 分类名称
     * @return 1操作成功 0操作失败
     */
    int updateCategoryInfo(int id,String name);

    /**
     *  添加类目
     * @param name 分类名称
     * @return 1操作成功 0操作失败
     */
    int addCategory(String name);

}
