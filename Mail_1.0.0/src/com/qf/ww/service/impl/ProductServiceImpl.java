package com.qf.ww.service.impl;

import com.qf.ww.dao.IProductDao;
import com.qf.ww.dao.impl.ProductDaoImpl;
import com.qf.ww.entity.Message;
import com.qf.ww.entity.Page;
import com.qf.ww.entity.Product;
import com.qf.ww.service.IProductService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class ProductServiceImpl implements IProductService {
    private final IProductDao productDao = new ProductDaoImpl();
    @Override
    public Page getPageByCid(int currentPage, int cid) {
        Page page = new Page();
        page.setCurrentPage(currentPage);
        page.setPageSize(3);
        page.setTotalCount(productDao.getTotalCountByCid(cid));
        List<Product> list = productDao.getPageByCid(cid, (currentPage - 1) * page.getPageSize(), page.getPageSize());
        page.setList(list);
        return page;
    }

    @Override
    public Message getProductByCid(int cid) {
        List<Product> list = productDao.getProductByCid(cid);
        return new Message(list);
    }

    @Override
    public Message addProduct(List<FileItem> list, String path) throws IOException, InvocationTargetException, IllegalAccessException {
        Product product = new Product();
        HashMap<String, String> map = new HashMap<>();
        for (FileItem fileItem : list) {
            //判断是否为非文本信息
            if (!fileItem.isFormField()) {
                InputStream is = fileItem.getInputStream();
                File file = new File(path);
                if (!file.exists()) {
                    file.mkdirs();
                }
                //改变文件名
                String fileName = fileItem.getName();
                UUID uuid = UUID.randomUUID();
                fileName = uuid + "_" + fileName;

                FileOutputStream fos = new FileOutputStream(new File(path, fileName));
                IOUtils.copy(is, fos);
                fos.close();
                is.close();
                //存储图片的名字
                product.setImgUrl(fileName);
            } else {
                //userName  --  hobbies -- hobbies
                String value = map.get(fileItem.getFieldName());
                if (value == null) {
                    map.put(fileItem.getFieldName(), fileItem.getString("utf-8"));
                } else {
                    map.put(fileItem.getFieldName(), value + "," + fileItem.getString("utf-8"));
                }
            }
        }
        BeanUtils.populate(product, map);
        product.setCreateDate(new Date());
        System.out.println(product);
        productDao.addProduct(product);
        return new Message("success");
    }

    @Override
    public Message deleteProduct(int id) {
        productDao.deleteProduct(id);
        return new Message("success");
    }

    @Override
    public Message getProductList() {
        List<Product> list = productDao.getProductList();
        return new Message(list);
    }
}
