package com.qf.ww.servlet;

import com.qf.ww.entity.Message;
import com.qf.ww.entity.Page;
import com.qf.ww.service.IProductService;
import com.qf.ww.service.impl.ProductServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

@WebServlet("/ProductServlet")
public class ProductServlet extends BaseServlet{
    private final IProductService productService = new ProductServiceImpl();

    /**
     *  获取分类产品信息功能
     * @param request
     * @param response
     * @return
     */
    public Page getPageByCid(HttpServletRequest request, HttpServletResponse response){
        int currentPage = Integer.parseInt(request.getParameter("currentPage")) ;
        int cid = Integer.parseInt(request.getParameter("cid"));
        Page page = productService.getPageByCid(currentPage, cid);
        return page;
    }

    public Message getProductByCid(HttpServletRequest request, HttpServletResponse response){
        int cid = Integer.parseInt(request.getParameter("cid"));
        Message message = productService.getProductByCid(cid);
        return message;
    }

    public Message addProduct(HttpServletRequest request, HttpServletResponse response) throws FileUploadException, IOException, InvocationTargetException, IllegalAccessException {
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> list = upload.parseRequest(request);
        String path= getServletContext().getRealPath("img");
        Message message = productService.addProduct(list, path);
        return message;
    }

    public Message deleteProduct(HttpServletRequest request, HttpServletResponse response){
        int id =Integer.parseInt(request.getParameter("id")) ;
        Message message = productService.deleteProduct(id);
        return message;
    }

    public Message getProductList(HttpServletRequest request, HttpServletResponse response){
        Message message = productService.getProductList();
        return message;
    }
}
