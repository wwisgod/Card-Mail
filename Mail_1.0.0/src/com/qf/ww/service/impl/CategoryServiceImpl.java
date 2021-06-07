package com.qf.ww.service.impl;

import com.qf.ww.dao.ICategoryDao;
import com.qf.ww.dao.impl.CategoryDaoImpl;
import com.qf.ww.entity.Category;
import com.qf.ww.entity.Message;
import com.qf.ww.service.ICategoryService;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService {
    private final ICategoryDao categoryDao = new CategoryDaoImpl();
    @Override
    public Message getCategoryList() {
        List<Category> categoryList = categoryDao.getCategoryList();
        return new Message(categoryList);
    }

    @Override
    public Message deleteCategory(int id) {
        int rSet = categoryDao.deleteCategory(id);
        if (rSet==1){
            return new Message("success");
        }else {
            return new Message("error");
        }
    }

    @Override
    public Message getCategoryInfo(int id) {
        List<Category> categoryInfo = categoryDao.getCategoryInfo(id);
        return new Message(categoryInfo);
    }

    @Override
    public Message updateCategoryInfo(int id, String name) {
        int rSet = categoryDao.updateCategoryInfo(id, name);
        if (rSet==1){
            return new Message("success");
        }else {
            return new Message("error");
        }
    }

    @Override
    public Message addCategory(String name) {
        int rSet = categoryDao.addCategory(name);
        if (rSet==1){
            return new Message("success");
        }else {
            return new Message("error");
        }
    }


}
