package com.qf.ww.servlet;

import com.qf.ww.entity.Message;
import com.qf.ww.service.ICategoryService;
import com.qf.ww.service.impl.CategoryServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CategoryServlet")
public class CategoryServlet extends BaseServlet{
    private final ICategoryService categoryService = new CategoryServiceImpl();
    /**
     *  获取所有类目功能
     * @param request
     * @param response
     * @return
     */
    public Message getCategoryList(HttpServletRequest request, HttpServletResponse response){
        Message message = categoryService.getCategoryList();
        return message;
    }


    /**
     *  删除所选类目功能
     * @param request
     * @param response
     * @return
     */
    public Message deleteCategory(HttpServletRequest request,HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        Message message = categoryService.deleteCategory(id);
        return message;
    }

    /**
     *  获取修改类目信息功能
     * @param request
     * @param response
     * @return
     */
    public Message getCategoryInfo(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        Message message = categoryService.getCategoryInfo(id);
        return message;
    }

    /**
     *  修改分类名称功能
     * @param request
     * @param response
     * @return
     */
    public Message updateCategoryInfo(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Message message = categoryService.updateCategoryInfo(id, name);
        return message;
    }

    /**
     *  新增分类功能
     * @param request
     * @param response
     * @return
     */
    public Message addCategory(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("name");
        Message message = categoryService.addCategory(name);
        return message;
    }
}
