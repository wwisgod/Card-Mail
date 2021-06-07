package com.qf.ww.dao.impl;

import com.qf.ww.dao.ICategoryDao;
import com.qf.ww.entity.Category;
import com.qf.ww.utils.DBManager;

import java.util.List;

public class CategoryDaoImpl implements ICategoryDao {
    @Override
    public List<Category> getCategoryList() {
        List<Category> list = DBManager.commonQuery("select * from category", Category.class);
        return list;
    }

    @Override
    public int deleteCategory(int id) {
        Integer rSet = DBManager.commonUpdate("delete from category where id=?", id);
        return rSet;
    }

    @Override
    public List<Category> getCategoryInfo(int id) {
        List<Category> list = DBManager.commonQuery("select * from category where id=?", Category.class, id);
        return list;
    }

    @Override
    public int updateCategoryInfo(int id, String name) {
        Integer rSet = DBManager.commonUpdate("update category set name=? where id=?", name, id);
        return rSet;
    }

    @Override
    public int addCategory(String name) {
        Integer rSet = DBManager.commonUpdate("insert into category(name) value(?)", name);
        return rSet;
    }


}
